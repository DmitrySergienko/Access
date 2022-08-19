package com.access.domain


import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response


interface AccessRepo {

    suspend fun pushLogin(post: LoginRequest): Response<LoginResponse>
    suspend fun pushRegistration(post: ReguistrationRequest): Response<Void>

}