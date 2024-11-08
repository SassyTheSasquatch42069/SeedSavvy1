package com.example.seed_savvy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        // Find the ImageViews representing the categories
        val imageViewCreateCategory = findViewById<View>(R.id.category_click)
        val imageViewAddItem = findViewById<View>(R.id.item_click)
        val imageViewViewList = findViewById<View>(R.id.category_click_2)
        val imageViewGoal = findViewById<View>(R.id.item_click_2)
        val imageViewAchievements = findViewById<View>(R.id.category_click_3)
        val imageViewSeasonsTracker = findViewById<View>(R.id.item_click_3)
        val imageViewEditTeams = findViewById<View>(R.id.category_click_4)
        val imageViewEditCategory = findViewById<View>(R.id.item_click_4)
        val imageViewLogout = findViewById<ImageView>(R.id.logout)

        // Set click listeners for each category to switch the content view
        imageViewCreateCategory.setOnClickListener {
            startActivity(Intent(this, CreateCategoryActivity::class.java))

        }

        imageViewAddItem.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))


        }

        imageViewViewList.setOnClickListener {
            startActivity(Intent(this, ViewListActivity::class.java))

        }

        imageViewGoal.setOnClickListener {
            startActivity(Intent(this, GoalActivity::class.java))

        }

        imageViewAchievements.setOnClickListener {
            startActivity(Intent(this, AchievementActivity::class.java))

        }

        imageViewSeasonsTracker.setOnClickListener {
            startActivity(Intent(this, SeasonsActivity::class.java))

        }



        imageViewLogout.setOnClickListener {
            // Create an intent to navigate back to MainActivity
            val intent = Intent(this@MainMenuActivity, MainActivity::class.java)
            // Add any extra data to the intent if needed
            // For example, if you want to pass some data back to MainActivity:
            // intent.putExtra("key", value)

            startActivity(Intent(this, MainActivity::class.java))
            // Start the MainActivity using the intent
            startActivity(intent)

            // Finish the current activity (optional)
            finish()
        }
    }
}
