package com.nextgen.tes.data.remote.response.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("meta")
	val meta: Meta
)

data class Data(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("token_type")
	val tokenType: String,

	@field:SerializedName("customer")
	val customer: Customer
)

data class Meta(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class Customer(

	@field:SerializedName("is_active")
	val isActive: String,

	@field:SerializedName("udt")
	val udt: String,

	@field:SerializedName("avatar")
	val avatar: String,

	@field:SerializedName("token")
	val token: String,

	@field:SerializedName("cust_code")
	val custCode: String,

	@field:SerializedName("uid")
	val uid: Any,

	@field:SerializedName("cdt")
	val cdt: String,

	@field:SerializedName("group_id")
	val groupId: Int,

	@field:SerializedName("firebase_key")
	val firebaseKey: String,

	@field:SerializedName("device_token")
	val deviceToken: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("phone_number")
	val phoneNumber: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("cust_id")
	val custId: Int,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("cid")
	val cid: Int
)
