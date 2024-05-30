package com.example.seed_savvy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val usernameEditText = findViewById<EditText>(R.id.Name_txt)
        val passwordEditText = findViewById<EditText>(R.id.password_txt)
        val showPasswordSwitch = findViewById<RadioButton>(R.id.show_password_switch)
        val loginButton = findViewById<Button>(R.id.Login_button)
        val createButton = findViewById<Button>(R.id.Create_button)

        loginButton.setOnClickListener {
            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredUsername.isNotEmpty() && enteredPassword.isNotEmpty()) {
                if (isPasswordValid(enteredPassword)) {
                    if (savedUsername == enteredUsername && savedPassword == enteredPassword) {
                        // Login successful, navigate to homepage
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, MainMenuActivity::class.java))
                        finish()
                    } else {
                        // Login failed, show error message or handle accordingly
                        Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show()
                    }
                } else {
                    // Invalid password format
                    Toast.makeText(this, "Password does not meet the required criteria", Toast.LENGTH_LONG).show()
                }
            } else {
                // Username or password is empty, show error message
                Toast.makeText(this, "Please enter Username and Password", Toast.LENGTH_LONG).show()
            }
        }

        createButton.setOnClickListener {
            // Navigate to registration page
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        val minLength = 12
        val pattern = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\$%^&*(),.?\":{}|<>]).{$minLength,}$")
        return password.length >= minLength && password.matches(pattern)
    }
}
