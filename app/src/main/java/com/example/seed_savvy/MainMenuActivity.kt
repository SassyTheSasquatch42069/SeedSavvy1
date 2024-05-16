package com.example.seed_savvy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

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

        val imageViewLogout = findViewById<View>(R.id.logout)

        // Set click listeners for each category to switch the content view
        imageViewCreateCategory.setOnClickListener {
            setContentView(R.layout.create_category)
        }

        imageViewAddItem.setOnClickListener {
            setContentView(R.layout.add_item)
        }

        imageViewViewList.setOnClickListener {
            setContentView(R.layout.view_list)
        }

        imageViewGoal.setOnClickListener {
            setContentView(R.layout.goal)
        }

        imageViewAchievements.setOnClickListener {
            setContentView(R.layout.achievement)
        }

        imageViewSeasonsTracker.setOnClickListener {
            setContentView(R.layout.seasons)
        }



        imageViewLogout.setOnClickListener {
            // Handle logout action here
        }
    }
}
