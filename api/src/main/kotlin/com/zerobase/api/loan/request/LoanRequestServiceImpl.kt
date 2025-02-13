package com.zerobase.api.loan.request

import com.zerobase.api.loan.GenerateKey
import com.zerobase.data.repository.UserInfoRepository
import com.zerobase.data.domain.UserInfo
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository
) : LoanRequestService {
    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {

        // userKey 값을 받아와서 생성
        val userKey = generateKey.generateUserKey()
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