package br.com.simon.environmentthreats

import java.time.LocalDateTime

data class EnvironmentThreat (

    val id: Long,
    val address: String,
    val date: LocalDateTime,
    val description: String

)