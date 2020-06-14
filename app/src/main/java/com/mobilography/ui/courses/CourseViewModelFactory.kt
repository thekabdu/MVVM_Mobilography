package com.mobilography.ui.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilography.data.repository.CourseRepository


@Suppress("UNCHECKED_CAST")
class CourseViewModelFactory(

    private val repository: CourseRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CourseViewModel(repository) as T
    }
}
