package com.mobilography.ui.courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilography.data.model.Course
import com.mobilography.data.repository.CourseRepository
import com.mobilography.util.Coroutines

import kotlinx.coroutines.Job

class CourseViewModel(
    private val repository: CourseRepository
):ViewModel() {

    private lateinit var job: Job

    private val _course = MutableLiveData<List<Course>>()
    val course: LiveData<List<Course>>
        get()= _course

    fun getCourse(){
        job = Coroutines.ioThenMain(
        {  repository.getCourse()},
            {_course.value = it }

            )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }


}