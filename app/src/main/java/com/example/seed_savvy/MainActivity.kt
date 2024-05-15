package com.example.seed_savvy
// LoginActivity.kt
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.seed_savvy.RegisterActivity

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

            if (savedUsername == enteredUsername && savedPassword == enteredPassword) {
                // Login successful, navigate to homepage
                setContentView(R.layout.main_menu)
            } else {
                // Login failed, show error message or handle accordingly
            }
        }

        createButton.setOnClickListener {
            // Navigate to registration page
            setContentView(R.layout.register)
        }
    }
}

