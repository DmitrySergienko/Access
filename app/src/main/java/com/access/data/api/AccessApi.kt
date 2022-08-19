package com.access.data.api

import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface  AccessApi {

    @POST("pls/apex/pmstest/MobileApp/login")
    suspend fun pushLogin(@Body post: LoginRequest): Response<LoginResponse>

    @POST("pls/apex/pmstest/MobileApp/registration")
    suspend fun pushRegistration(@Body post: ReguistrationRequest): Response<Void>

}