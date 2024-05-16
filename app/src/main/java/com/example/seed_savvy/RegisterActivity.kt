package com.example.seed_savvy
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
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
            // Your registration logic
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Optional: Close current activity
        }

        // Handling back button press using OnBackPressedCallback
        val callback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                // Navigate back to login page
                startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                finish() // Optional: Close current activity
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)

        // Disable the callback if needed
        // callback.isEnabled = false
    }
}


