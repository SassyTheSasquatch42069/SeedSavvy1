// CategoryAndItemArrays.kt

package com.example.seed_savvy
class CategoryAndItemLists {}
    // Define the Category data class
    data class Category(
        val categoryName: String,
        val categoryGoal: String,
        val categoryDate: String
    )

    // Define the Item data class
    data class Item(
        val itemName: String,
        val itemDescription: String,
        val itemDate: String,
        val category: Category // Link item to a category
    )

    // Store categories and items using arrays
    object CategoryAndItemArrays {
        val categoryArray = arrayOf<Category>()
        var itemArray = arrayOf<Item>()
    }

