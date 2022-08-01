package com.access.domain

import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response

interface AccessTypesRepository {

    suspend fun pushPostLog(post: LoginRequest) : Response<LoginResponse>

    suspend fun pushPostReg(post: ReguistrationRequest): Response<Void>
}