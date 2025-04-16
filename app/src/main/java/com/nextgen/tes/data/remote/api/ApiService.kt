package com.nextgen.tes.data.remote.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/api/customer/auth/login")
    fun setLogin(
        @Field("username") username: String,
        @Field("password") password: String
    )
}