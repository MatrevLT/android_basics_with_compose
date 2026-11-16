package com.example.a30days.model

import com.example.a30days.R

object WellnessRepository {
    val days: List<Day> = listOf(
        Day(1, R.string.day1_title, R.string.day1_desc, R.drawable.wellness_day1),
        Day(2, R.string.day2_title, R.string.day2_desc, R.drawable.wellness_day2),
        Day(3, R.string.day3_title, R.string.day3_desc, R.drawable.wellness_day3),

        Day(30, R.string.day30_title, R.string.day30_desc, R.drawable.wellness_day30)
    )
}
