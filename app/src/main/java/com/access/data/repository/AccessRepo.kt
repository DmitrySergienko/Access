package com.access.data.repository

import com.access.data.api.AccessApi
import com.access.data.api.model.Login
import com.access.data.api.model.Signup
import retrofit2.Response
import javax.inject.Inject

class AccessRepo @Inject constructor(
    private val accessApi: AccessApi
) {

    suspend fun pushPostLog(post: Login): Response<Signup> {
        return accessApi.pushlogin(post)
    }
}