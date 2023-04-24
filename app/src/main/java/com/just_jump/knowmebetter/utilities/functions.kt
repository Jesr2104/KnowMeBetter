package com.just_jump.knowmebetter.utilities

import androidx.navigation.NavHostController
import com.just_jump.knowmebetter.domain.datamodels.CategoryDataModel

// Function de Set Data to the serializable
fun <T> NavHostController.passOnDataSet(key: String, value: T) {
    this.currentBackStackEntry?.savedStateHandle?.set(key = key, value = value)
}

// Function to Get Data from the serializable
inline fun <reified T> NavHostController.passOnDataGet(key: String): T? {
    return this.previousBackStackEntry?.savedStateHandle?.get<T>(key)
}

fun getCategoryNameById(categoryId: Int,  categories: List<CategoryDataModel>): String? {
    return categories.find { it.id == categoryId }?.name
}

fun getCategory(): List<CategoryDataModel> {
    return listOf(
        CategoryDataModel(
            id = 11111,
            name = "Mixed category",
            description = "Use the content of all categories."),
        CategoryDataModel(
            id = 12345,
            name = "Self-improvement",
            description = "Questions about self-growth and personal development."
        ),
        CategoryDataModel(
            id = 23456,
            name = "Bucket list",
            description = "Questions about things you want to do before you die."),
        CategoryDataModel(
            id = 34567,
            name = "Spicy topics",
            description = "Questions about controversial or taboo subjects."),
        CategoryDataModel(
            id = 45678,
            name = "Personal happiness and fulfillment",
            description = "Questions about what makes you happy and fulfilled."
        ),
        CategoryDataModel(
            id = 56789,
            name = "Random and miscellaneous",
            description = "Questions about a variety of topics."),
        CategoryDataModel(
            id = 67890,
            name = "Personal values and beliefs",
            description = "Questions about your core values and beliefs."
        ),
        CategoryDataModel(
            id = 78901,
            name = "Future goals and aspirations",
            description = "Questions about your long-term goals and aspirations."
        ),
        CategoryDataModel(
            id = 89012,
            name = "Relationships and emotions",
            description = "Questions about your relationships and emotional life."
        ),
        CategoryDataModel(
            id = 90123,
            name = "Interests and passions",
            description = "Questions about your hobbies, interests, and passions."
        )
    )
}