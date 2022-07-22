package com.access.data.api

import com.access.data.api.model.LoginRequest
import com.access.data.api.model.LoginResponse
import com.access.data.api.model.ReguistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface  AccessApi {

    @POST("pls/apex/pmstest/MobileApp/login")
    suspend fun pushLogin(
        @Body post: LoginRequest
    ): Response<LoginResponse>

    @POST("pls/apex/pmstest/MobileApp/registration")
    suspend fun pushRegistration(
        @Body post: ReguistrationRequest
    ): Response<Any>

}