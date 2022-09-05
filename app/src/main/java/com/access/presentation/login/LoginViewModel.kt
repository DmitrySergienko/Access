package com.access.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.access.domain.entity.LoginRequest
import com.access.domain.entity.LoginResponse
import com.access.domain.usecases.AccessRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AccessRepoUseCase
) : ViewModel() {

    private val _loginSharedFlow = MutableSharedFlow<Response<LoginResponse>>()
    val loginSharedFlow = _loginSharedFlow.asSharedFlow()


    fun pushLogin(post: LoginRequest) {
        viewModelScope.launch {
            val response: Response<LoginResponse> = repo.pushLogin(post)

            _loginSharedFlow.emit(response)
        }
    }

}