package com.zerobase.api.test

import com.zerobase.data.domain.UserInfo
import com.zerobase.data.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService (
    private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}