package com.nextgen.tes.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextgen.tes.data.repo.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun getUserLogin(username: String, password: String) =
        authRepository.getUserLogin(username, password)

    fun saveToken(token: String) {
        viewModelScope.launch {
            authRepository.saveToken(token)
        }
    }
}