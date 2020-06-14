package com.mobilography.data.networking



import com.mobilography.data.model.Course
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CourseApi {
    @GET("mobilography")
   suspend fun getCourse(): Response<List<Course>>

    companion object{
        operator fun invoke(): CourseApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://my-json-server.typicode.com/thekabdu/mobilography/")
                .build()
                .create(CourseApi::class.java)
        }
    }
}