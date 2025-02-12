package com.zerobase.api.test

class TestDto {
    data class UserInfoDto(
        val userKey: String,
        val userRegisterationNumber: String,
        val userName: String,
        val userIncomeAmount: Long
    ){

    }
}