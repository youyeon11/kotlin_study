package com.zerobase.data.repository

import com.zerobase.data.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String): UserInfo
}