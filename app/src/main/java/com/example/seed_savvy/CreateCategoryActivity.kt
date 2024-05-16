package com.example.seed_savvy

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateCategoryActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var categoryNames: Array<String>
    private lateinit var categoryGoals: Array<String>
    private lateinit var categoryDates: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_category)

        sharedPreferences = getSharedPreferences("CategoryPrefs", Context.MODE_PRIVATE)

        val categoryNameEditText = findViewById<EditText>(R.id.category_Nametxt)
        val categoryGoalEditText = findViewById<EditText>(R.id.category_Goaltxt)
        val categoryDateEditText = findViewById<EditText>(R.id.category_Datetxt)
        val saveCategoryButton = findViewById<Button>(R.id.create_cat_click)
        val backButton = findViewById<Button>(R.id.back_button_click)

        saveCategoryButton.setOnClickListener {
            val categoryName = categoryNameEditText.text.toString().trim()
            val categoryGoal = categoryGoalEditText.text.toString().trim()
            val categoryDate = categoryDateEditText.text.toString().trim()

            if (categoryName.isNotEmpty() && categoryGoal.isNotEmpty() && categoryDate.isNotEmpty()) {
                // Save category details in arrays
                saveCategoryDetails(categoryName, categoryGoal, categoryDate)

                // Save category details in SharedPreferences
                saveCategoryToSharedPreferences(categoryName, categoryGoal, categoryDate)

                // Clear EditText fields
                categoryNameEditText.text.clear()
                categoryGoalEditText.text.clear()
                categoryDateEditText.text.clear()
            } else {
                // Show error message if any field is empty
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish() // Close current activity and go back
        }
    }

    private fun saveCategoryDetails(name: String, goal: String, date: String) {
        categoryNames += name
        categoryGoals += goal
        categoryDates += date
    }

    private fun saveCategoryToSharedPreferences(name: String, goal: String, date: String) {
        val editor = sharedPreferences.edit()
        editor.putString("categoryName", name)
        editor.putString("categoryGoal", goal)
        editor.putString("categoryDate", date)
        editor.apply()
    }
}
