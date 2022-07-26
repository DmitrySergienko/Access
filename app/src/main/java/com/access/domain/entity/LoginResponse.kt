package com.access.domain.entity

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("EMAIL")
	val pEMAIL: String? = null,

	@field:SerializedName("LOGIN_FLAG")
	val pLOGIN_FLAG: String? = null,


	@field:SerializedName("PASSWORD")
	val pPASSWORD: String? = null,

	@field:SerializedName("LAST_NAME")
	val pLASTNAME: String? = null,

	@field:SerializedName("PHONE")
	val pPHONE: String? = null,

	@field:SerializedName("FIRST_NAME")
	val pFIRSTNAME: String? = null
)
