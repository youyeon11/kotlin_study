package com.zerobase.api.loan.request

import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.data.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
) : LoanRequestService {
    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        // userKey 값을 받아와서 생성
        val userKey = generateKey.generateUserKey()

        // 주민등록번호 암호화
        loanRequestInputDto.userRegistrationNumber= encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview("")

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    // user 정보 받아오기
    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        // user의 정보 저장
        userInfoRepository.save(userInfoDto.toEntity())


    // 대출 심사
    override fun loanRequestReview(userKey: String) {
        TODO("Not yet implemented")
    }
}