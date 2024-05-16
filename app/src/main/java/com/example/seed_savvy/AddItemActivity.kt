package com.example.seed_savvy
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.seed_savvy.Category
import com.example.seed_savvy.CategoryAndItemArrays
import com.example.seed_savvy.Item
import com.example.seed_savvy.R

class AddItemActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var categoryNameEditText: EditText
    private lateinit var itemDescriptionEditText: EditText
    private lateinit var itemDateEditText: EditText
    private lateinit var saveItemButton: Button
    private lateinit var backButton: Button
    private lateinit var genderRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item)
        sharedPreferences = getSharedPreferences("ItemPrefs", Context.MODE_PRIVATE)

        categoryNameEditText = findViewById(R.id.category_name_EditText)
        itemDescriptionEditText = findViewById(R.id.nameEditText)
        itemDateEditText = findViewById(R.id.surnameEditText)
        saveItemButton = findViewById(R.id.create_cat_click)
        backButton = findViewById(R.id.back_button_click)
        genderRadioGroup = findViewById(R.id.RadioGroup)


        saveItemButton.setOnClickListener {
            val itemName = categoryNameEditText.text.toString().trim()
            val itemDescription = itemDescriptionEditText.text.toString().trim()
            val itemDate = itemDateEditText.text.toString().trim()

            val selectedRadioButtonId = genderRadioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedCategory = selectedRadioButton.text.toString()

            val categoryIndex = getCategoryIndex(selectedCategory)

            if (itemName.isNotEmpty() && itemDescription.isNotEmpty() && itemDate.isNotEmpty() && categoryIndex != -1) {
                // Save item details to arrays
                saveItemDetails(itemName, itemDescription, itemDate, categoryIndex)

                // Save item details in SharedPreferences
                saveItemToSharedPreferences(itemName, itemDescription, itemDate)

                Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show()

                // Clear EditText fields
                categoryNameEditText.text.clear()
                itemDescriptionEditText.text.clear()
                itemDateEditText.text.clear()
            } else {
                // Show error message if any field is empty or category index is invalid
                Toast.makeText(this, "Please fill in all fields and select a category", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            finish() // Close current activity and go back
        }
    }

    private fun saveItemDetails(name: String, description: String, date: String, categoryIndex: Int) {
        val category = CategoryAndItemArrays.categoryArray[categoryIndex]
        CategoryAndItemArrays.itemArray += Item(name, description, date, category)

    }

    private fun saveItemToSharedPreferences(name: String, description: String, date: String) {
        val editor = sharedPreferences.edit()
        editor.putString("itemName", name)
        editor.putString("itemDescription", description)
        editor.putString("itemDate", date)
        editor.apply()
    }

    private fun getCategoryIndex(categoryName: String): Int {
        for ((index, category) in CategoryAndItemArrays.categoryArray.withIndex()) {
            if (category.categoryName == categoryName) {
                return index
            }
        }
        return -1
    }
}
