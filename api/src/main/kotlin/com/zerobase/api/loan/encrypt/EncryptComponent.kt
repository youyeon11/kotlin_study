package com.zerobase.api.loan.encrypt

import org.springframework.stereotype.Component
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

@Component
class EncryptComponent {
    //key 값(서비스 체크 임시)
    companion object {
        private const val secretKey = "12345678901234567890123456"
    }

    // encoding, decoder 설정
    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    // 암호화 함수
    fun encryptString(encryptString: String): String {
        val encryptedString = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey).doFinal(encryptString.toByteArray(Charsets.UTF_8))

        return String(encoder.encode(encryptedString))
    }

    // 복호화 함수
    fun decryptString(decryptString: String): String {
        val byteString = decoder.decode(decryptString.toByteArray(Charsets.UTF_8))

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    // secretKey에서 암호화 생성 함수
    fun cipherPkcs5(opMode: Int, secretKey: String): Cipher {
        // SecretKeySpec을 사용하여 비밀키를 생성
        val keySpec = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")

        // Cipher 인스턴스를 초기화 (AES 알고리즘, ECB 모드, PKCS#5 패딩 사용)
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")

        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))

        // 암호화 또는 복호화 모드 설정
        cipher.init(opMode, keySpec, iv)

        return cipher
    }
}