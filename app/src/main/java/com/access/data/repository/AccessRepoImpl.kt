package com.access.data.repository


import com.access.data.api.AccessApi
import com.access.domain.AccessRepo
import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.entity.ReguistrationRequest
import retrofit2.Response
import javax.inject.Inject


class AccessRepoImpl @Inject constructor(
    private val accessApi: AccessApi
) : AccessRepo {


    override suspend fun pushLogin(post: LoginRequest): Response<LoginResponse> {
        return accessApi.pushLogin(post)

    }


    override suspend fun pushRegistration(post: ReguistrationRequest): Response<Void> {
        return accessApi.pushRegistration(post)

    }

}






