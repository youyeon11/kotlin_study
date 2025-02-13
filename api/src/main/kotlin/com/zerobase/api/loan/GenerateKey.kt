package com.zerobase.api.loan

import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateKey {
    // java에서 제공하는 UUID 기능 사용
    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "")
}