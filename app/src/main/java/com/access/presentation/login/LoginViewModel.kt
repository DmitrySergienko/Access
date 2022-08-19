package com.access.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.access.data.repository.AccessRepoImpl
import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AccessRepoImpl
) : ViewModel() {

    private val _loginLiveData = MutableLiveData<Response<LoginResponse>>()
    val loginLiveData: LiveData<Response<LoginResponse>> = _loginLiveData


    fun pushLogin(post: LoginRequest) {
        viewModelScope.launch {
            val response: Response<LoginResponse> = repo.pushLogin(post)

            _loginLiveData.value = response
        }
    }

}