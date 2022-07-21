package com.access.data.api.model

import com.google.gson.annotations.SerializedName

data class Signup(

	@field:SerializedName("P_EMAIL")
	val pEMAIL: String? = null,

	@field:SerializedName("P_PASSWORD")
	val pPASSWORD: String? = null,

	@field:SerializedName("P_LAST_NAME")
	val pLASTNAME: String? = null,

	@field:SerializedName("P_PHONE")
	val pPHONE: String? = null,

	@field:SerializedName("P_FIRST_NAME")
	val pFIRSTNAME: String? = null
)
