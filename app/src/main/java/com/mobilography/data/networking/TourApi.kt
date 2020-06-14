package com.mobilography.data.networking

import com.mobilography.data.model.Tour
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TourApi {
    @GET("tour")
    suspend fun getTour(): Response<List<Tour>>

    companion object{
        operator fun invoke(): TourApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://my-json-server.typicode.com/thekabdu/tour/")
                .build()
                .create(TourApi::class.java)
        }

    }
}