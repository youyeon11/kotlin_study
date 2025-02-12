package com.zerobase.data.repository

import com.zerobase.data.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String): UserInfo
}