package com.access.domain.usecases


import com.access.domain.AccessRepo
import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response
import javax.inject.Inject

class AccessRepoUseCase @Inject constructor(
    private val accessRepo: AccessRepo
)  {

    suspend fun pushPostLog(post: LoginRequest): Response<LoginResponse> {
        return accessRepo.pushLogin(post)
    }

    suspend fun pushPostReg(post: ReguistrationRequest): Response<Void> {
        return accessRepo.pushRegistration(post)
    }
}