package com.example.incident_list_demo_kmp

import kotlinx.datetime.LocalDateTime

data class Incident(
    val id: Int,
    val category: String,
    val description: String,
    val priority: Priority,
    val status: String,
    val reportedAt: LocalDateTime
)

enum class Priority(val label: String, val deadlineDays: Long) {
    LOW("Low", 7),
    MEDIUM("Medium", 3),
    HIGH("High", 1)
}
