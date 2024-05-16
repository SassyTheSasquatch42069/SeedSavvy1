package com.example.seed_savvy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val goBackButton = findViewById<Button>(R.id.goBackButton)

        registerButton.setOnClickListener {
            // Your registration logic
            if (usernameEditText.text.trim().isNotEmpty()) {
                Toast.makeText(this, "Username Entered Successfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Close current activity
            } else {
                Toast.makeText(this, "Enter a Username", Toast.LENGTH_LONG).show()
            }
        }

        goBackButton.setOnClickListener {
            // Navigate back to login page

            finish() // Close current activity
        }
    }
}
