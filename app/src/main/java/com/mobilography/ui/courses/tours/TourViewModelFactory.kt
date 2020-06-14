package com.mobilography.ui.courses.tours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilography.data.repository.TourRepository

@Suppress("UNCHECKED_CAST")
class TourViewModelFactory (
    private val repositoryt: TourRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TourViewModel(repositoryt) as T
    }
}