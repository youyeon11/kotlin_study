package com.zerobase.data.repository

import com.zerobase.data.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

interface LoanReviewRepository : JpaRepository<LoanReview, Long>