package com.mobilography.data.repository

import com.mobilography.data.networking.CourseApi

class CourseRepository (
    private val api: CourseApi
) :  SafeApiRequest() {

        suspend fun getCourse() = apiRequest { api.getCourse() }
}
