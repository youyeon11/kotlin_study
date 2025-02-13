package com.zerobase.api.loan.request

import com.zerobase.data.domain.UserInfo
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class UserInfoDto (
    val userKey: String,
    val userName: String,
    val userRegistrationNumber: String,
    val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
        UserInfo(
            userKey, userRegistrationNumber, userName, userIncomeAmount
        )
}