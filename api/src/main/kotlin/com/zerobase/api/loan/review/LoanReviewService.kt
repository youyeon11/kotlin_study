package com.zerobase.api.loan.review

import org.springframework.stereotype.Service

@Service
interface LoanReviewService {
    fun loanReviewMain(
        // controller에서의 parameter인 userKey값을 받아오기
        userKey: String
    ) : LoanReviewDto.LoanReviewResponseDto // 반환타입 설정

    fun getLoanResult(userKey: String) : LoanReviewDto.LoanReview
}