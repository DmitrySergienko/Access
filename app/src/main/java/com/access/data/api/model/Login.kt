package com.access.data.api.model

import com.google.gson.annotations.SerializedName


data class Login(

	@field:SerializedName("P_EMAIL")
	val pEMAIL: String? = null,

	@field:SerializedName("P_PASSWORD")
	val pPASSWORD: String? = null
)
