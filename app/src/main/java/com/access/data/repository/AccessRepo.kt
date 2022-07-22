package com.access.data.repository

import com.access.data.api.AccessApi
import com.access.data.api.model.LoginRequest
import com.access.data.api.model.LoginResponse
import com.access.data.api.model.ReguistrationRequest
import retrofit2.Response
import javax.inject.Inject

class AccessRepo @Inject constructor(
    private val accessApi: AccessApi
) {

    suspend fun pushPostLog(post: LoginRequest): Response<LoginResponse> {
        return accessApi.pushLogin(post)
    }
    suspend fun pushPostReg(post:ReguistrationRequest): Response<Void>{
        return  accessApi.pushRegistration(post)
    }
}