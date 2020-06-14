package com.mobilography.data.repository

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequestT {

    suspend fun <T: Any> apiRequestT(call: suspend () -> Response<T>) : T{
        val  response = call.invoke()
        if (response.isSuccessful){
            return response.body()!!
        }else {
            throw ApiExceptionT(response.code().toString())
        }
    }
}

class ApiExceptionT(message: String): IOException(message)