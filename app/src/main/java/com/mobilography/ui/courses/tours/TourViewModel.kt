package com.mobilography.ui.courses.tours

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilography.data.model.Tour
import com.mobilography.data.repository.TourRepository
import com.mobilography.util.Coroutines
import com.mobilography.util.CoroutinesT
import kotlinx.coroutines.Job

class TourViewModel (
    private val repositoryt: TourRepository
): ViewModel() {
    private lateinit var job: Job

    private val _tour = MutableLiveData<List<Tour>>()
    val tour: LiveData<List<Tour>>
        get()= _tour

    fun getTour(){
        job = CoroutinesT.ioThenMainT(
            {  repositoryt.getTour()},
            {_tour.value = it }

        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
