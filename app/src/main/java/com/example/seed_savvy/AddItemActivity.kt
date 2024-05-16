package com.example.seed_savvy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {

   /* private lateinit var categoryNameEditText: EditText
    private lateinit var itemDescriptionEditText: EditText
    private lateinit var itemDateEditText: EditText
    private lateinit var saveItemButton: Button
    private lateinit var backButton: Button
    private lateinit var genderRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item)

        categoryNameEditText = findViewById(R.id.category_name_EditText)
        itemDescriptionEditText = findViewById(R.id.nameEditText)
        itemDateEditText = findViewById(R.id.surnameEditText)
        saveItemButton = findViewById(R.id.create_cat_click)
        backButton = findViewById(R.id.back_button_click)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)

        saveItemButton.setOnClickListener {
            val itemName = categoryNameEditText.text.toString().trim()
            val itemDescription = itemDescriptionEditText.text.toString().trim()
            val itemDate = itemDateEditText.text.toString().trim()

            val selectedRadioButtonId = genderRadioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedCategory = selectedRadioButton.text.toString()

            val categoryIndex = getCategoryIndex(selectedCategory)

            if (itemName.isNotEmpty() && itemDescription.isNotEmpty() && itemDate.isNotEmpty() && categoryIndex != -1) {
                val category = CategoryAndItemArrays.categoryList[categoryIndex]
                val newItem = Item(itemName, itemDescription, itemDate, category)
                CategoryAndItemArrays.itemList.add(newItem)

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

    private fun getCategoryIndex(categoryName: String): Int {
        for ((index, category) in CategoryAndItemArrays.categoryList.withIndex()) {
            if (category.categoryName == categoryName) {
                return index
            }
        }
        return -1
    } */
}
