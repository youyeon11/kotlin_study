package com.zerobase.api.loan.review

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController (
    private val loanReviewServiceImpl: LoanReviewServiceImpl
){

    @GetMapping("/review/{userKey}")
    fun getReviewData(
        @PathVariable userKey: String,
    ): ResponseEntity<LoanReviewDto.LoanReviewResponseDto> {
        return ResponseEntity.ok(
            loanReviewServiceImpl.loanReviewMain(userKey)
        )
    }
}