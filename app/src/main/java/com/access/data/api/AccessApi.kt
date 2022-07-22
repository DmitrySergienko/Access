package com.access.data.api

import com.access.data.api.model.Login
import com.access.data.api.model.Signup
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface  AccessApi {

    @POST("pls/apex/pmstest/MobileApp/login")
    suspend fun pushlogin(
        @Body post: Login
    ): Response<Signup>

}