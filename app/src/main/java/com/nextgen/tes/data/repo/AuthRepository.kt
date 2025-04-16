package com.nextgen.tes.data.repo

import com.nextgen.tes.data.local.AuthDataStore
import com.nextgen.tes.data.remote.api.ApiService
import com.nextgen.tes.data.remote.response.login.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authDataStore: AuthDataStore,
    private val apiService: ApiService
){

    fun getUserLogin(username: String, password: String): Flow<Result<LoginResponse>> = flow {
        try {
            val response = apiService.login(username, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    fun getToken(): Flow<String?> = authDataStore.getToken()

    suspend fun saveToken(token: String) {
        authDataStore.saveToken(token)
    }
}