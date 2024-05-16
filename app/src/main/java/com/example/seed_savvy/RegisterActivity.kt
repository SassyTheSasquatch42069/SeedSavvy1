package com.example.seed_savvy

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val surnameEditText = findViewById<EditText>(R.id.surnameEditText)
        val password1EditText = findViewById<EditText>(R.id.password1)
        val password2EditText = findViewById<EditText>(R.id.password2)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val maleRadioButton = findViewById<RadioButton>(R.id.maleRadioButton)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val goBackButton = findViewById<Button>(R.id.goBackButton)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.trim().toString()
            val name = nameEditText.text.trim().toString()
            val surname = surnameEditText.text.trim().toString()
            val password = password1EditText.text.trim().toString()
            val confirmPassword = password2EditText.text.trim().toString()
            val age = ageEditText.text.trim().toString()
            val gender = if (maleRadioButton.isChecked) "Male" else "Female"

            if (username.isNotEmpty() && name.isNotEmpty() && surname.isNotEmpty() && password.isNotEmpty()
                && confirmPassword.isNotEmpty() && age.isNotEmpty()
            ) {
                if (password == confirmPassword) {
                    // Save user registration data to SharedPreferences
                    with(sharedPreferences.edit()) {
                        putString("username", username)
                        putString("name", name)
                        putString("surname", surname)
                        putString("password", password)
                        putString("age", age)
                        putString("gender", gender)
                        apply()
                    }
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                    // You can start MainActivity or perform registration logic here
                    finish() // Close current activity
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        goBackButton.setOnClickListener {
            // Navigate back to previous activity
            finish() // Close current activity
        }
    }
}

