package com.access.domain.usecases


import com.access.data.repository.AccessRepoImpl
import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response
import javax.inject.Inject

class AccessRepoUseCase @Inject constructor(
    private val accessRepoImpl: AccessRepoImpl
)  {

    suspend fun pushLogin(post: LoginRequest): Response<LoginResponse> {
        return accessRepoImpl.pushLogin(post)
    }

    suspend fun pushRegistration(post: ReguistrationRequest): Response<Void> {
        return accessRepoImpl.pushRegistration(post)
    }
}