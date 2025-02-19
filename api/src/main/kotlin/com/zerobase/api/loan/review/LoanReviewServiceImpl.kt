package com.zerobase.api.loan.review

import com.zerobase.data.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {
    override fun loanReviewMain(userKey: String)
    : LoanReviewDto.LoanReviewResponseDto {
        // main 작성

        val loanResult = getLoanResult(userKey)

        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = LoanReviewDto.LoanResult(
                userLimitAmount = loanResult.loanLimitedAmount,
                userLoanInterest = loanResult.loanLoanInterest
            )
        )
    }

    override fun getLoanResult(userKey: String) : LoanReviewDto.LoanReview{
        val loanReview = loanReviewRepository.findByUserKey(userKey)

        return LoanReviewDto.LoanReview(
            loanReview.userKey,
            loanReview.loanLimitedAmount,
            loanReview.loanInterest
        )
    }
}