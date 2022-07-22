package com.access.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.access.data.api.AccessApi
import com.access.data.api.model.Login
import com.access.data.api.model.Signup
import com.access.data.repository.AccessRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AccessRepo
): ViewModel() {

    private val _loginLiveData = MutableLiveData<Response<Signup>>()
    val loginLiveData: LiveData<Response<Signup>> = _loginLiveData

    fun pushLogin(post: Login) {
        viewModelScope.launch {
            val response: Response<Signup> = repo.pushPostLog(post)

            _loginLiveData.value = response
        }
    }
}