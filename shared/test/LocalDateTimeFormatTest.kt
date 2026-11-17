package com.example.incident_list_demo_kmp

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.number
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTimeFormatTest {
    @Test
    fun toDisplayString_formats_dd_MM_HH_mm() {
        // Given a specific LocalDateTime
        val ldt = LocalDateTime(
            year = 2025,
            month = Month.NOVEMBER,
            day = 18,
            hour = 5,
            minute = 7,
            second = 0,
            nanosecond = 0
        )

        // When formatting
        val formatted = ldt.toDisplayString()

        // Then the expected format is dd-MM HH:mm
        assertEquals("18-11 05:07", formatted)
    }

    @Test
    fun localDate_formatting_dd_MM_yyyy() {
        val date = LocalDate(year = 2026, month = Month.MARCH, day = 5)
        val formatted = "${date.day.twoDigits()}-${date.month.number.twoDigits()}-${date.year}"
        assertEquals("05-03-2026", formatted)
    }

    @Test
    fun priority_deadlineDays() {
        assertEquals(7, Priority.LOW.deadlineDays)
        assertEquals(3, Priority.MEDIUM.deadlineDays)
        assertEquals(1, Priority.HIGH.deadlineDays)
    }
}
