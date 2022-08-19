package com.access.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.access.data.repository.AccessRepoImpl
import com.access.domain.entity.ReguistrationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repo: AccessRepoImpl
) : ViewModel() {

    private val _regLiveData = MutableLiveData<Response<Void>>()
    val regLiveData: LiveData<Response<Void>> = _regLiveData

    fun pushRegistration(post: ReguistrationRequest) {
        viewModelScope.launch {
            val response: Response<Void> = repo.pushRegistration(post)

            _regLiveData.value = response
        }
    }

}