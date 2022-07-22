package com.access.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.access.data.api.model.ReguistrationRequest
import com.access.data.repository.AccessRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repo: AccessRepo
) : ViewModel() {

    private val _regLiveData = MutableLiveData<Response<Void>>()
    val regLiveData: LiveData<Response<Void>> = _regLiveData

    fun pushRegistration(post: ReguistrationRequest) {
        viewModelScope.launch {
            val response: Response<Void> = repo.pushPostReg(post)

            _regLiveData.value = response
        }
    }
//    fun pushLogin(post: LoginRequest) {
//        viewModelScope.launch {
//            val response: Response<LoginResponse> = repo.pushPostLog(post)
//
//            _loginLiveData.value = response
//        }
//    }
}