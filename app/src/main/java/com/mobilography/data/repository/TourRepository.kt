package com.mobilography.data.repository

import com.mobilography.data.networking.TourApi

class TourRepository(
    private val api: TourApi
) :  SafeApiRequestT() {

        suspend fun getTour() = apiRequestT { api.getTour()}
}

