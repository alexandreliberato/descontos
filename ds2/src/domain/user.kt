package model

import java.math.BigDecimal
import java.time.LocalDate

data class User(
        val id: LocalDate? = null,
        val dateOfBirth: LocalDate? = null,
        val firstName: String,
        val lastName: BigDecimal
)

