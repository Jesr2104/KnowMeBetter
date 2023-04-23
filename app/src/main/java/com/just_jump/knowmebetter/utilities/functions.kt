package com.just_jump.knowmebetter.utilities

import com.just_jump.knowmebetter.domain.datamodels.MyCategory

fun getCategory(): List<MyCategory> {
    return listOf(
        MyCategory(12345, "Self-improvement", "Questions about self-growth and personal development"),
        MyCategory(23456, "Bucket list", "Questions about things you want to do before you die"),
        MyCategory(34567, "Spicy topics", "Questions about controversial or taboo subjects"),
        MyCategory(45678, "Personal happiness and fulfillment", "Questions about what makes you happy and fulfilled"),
        MyCategory(56789, "Random and miscellaneous", "Questions about a variety of topics"),
        MyCategory(67890, "Personal values and beliefs", "Questions about your core values and beliefs"),
        MyCategory(78901, "Future goals and aspirations", "Questions about your long-term goals and aspirations"),
        MyCategory(89012, "Relationships and emotions", "Questions about your relationships and emotional life"),
        MyCategory(90123, "Interests and passions", "Questions about your hobbies, interests, and passions")
    )
}