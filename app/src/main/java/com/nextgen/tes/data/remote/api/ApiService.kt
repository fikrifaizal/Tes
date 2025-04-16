package com.nextgen.tes.data.remote.api

import com.nextgen.tes.data.remote.response.login.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/api/customer/auth/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : LoginResponse
}