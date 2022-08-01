package com.access.domain

import com.access.data.api.AccessApi
import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response
import javax.inject.Inject

class AccessRepoUseCase @Inject constructor(
    private val accessApi: AccessApi

) : AccessTypesRepository {

    override suspend fun pushPostLog(post: LoginRequest): Response<LoginResponse> {
        return accessApi.pushLogin(post)
    }

    override suspend fun pushPostReg(post: ReguistrationRequest): Response<Void> {
        return accessApi.pushRegistration(post)
    }
}