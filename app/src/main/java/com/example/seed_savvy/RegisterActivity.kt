package com.example.seed_savvy
// RegistrationActivity.kt
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.seed_savvy.R

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
            val username = usernameEditText.text.toString()
            val password = password1EditText.text.toString()
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val age = ageEditText.text.toString()
            val gender = if (maleRadioButton.isChecked) "Male" else "Female"

            // Save user information to SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.putString("name", name)
            editor.putString("surname", surname)
            editor.putString("age", age)
            editor.putString("gender", gender)
            editor.apply()

            // Navigate back to login page
            setContentView(R.layout.activity_main)
        }

        goBackButton.setOnClickListener {
            // Navigate back to login page
            setContentView(R.layout.activity_main)
        }
    }
}

