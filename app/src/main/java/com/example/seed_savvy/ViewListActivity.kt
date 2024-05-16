package com.example.seed_savvy

import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_list)

        // Retrieve category name from intent
        val categoryName = intent.getStringExtra("categoryName")

        // Find the TableLayout to add rows
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

        // Iterate through the itemArray to find items with matching category
        for (item in CategoryAndItemArrays.itemArray) {
            if (item.category.categoryName == categoryName) {
                // Create a new row
                val tableRow = TableRow(this)

                // Create TextViews for each item detail
                val itemNameTextView = TextView(this)
                itemNameTextView.text = item.itemName

                val itemDescriptionTextView = TextView(this)
                itemDescriptionTextView.text = item.itemDescription

                val itemDateTextView = TextView(this)
                itemDateTextView.text = item.itemDate

                // Add TextViews to the row
                tableRow.addView(itemNameTextView)
                tableRow.addView(itemDescriptionTextView)
                tableRow.addView(itemDateTextView)

                // Add the row to the TableLayout
                tableLayout.addView(tableRow)
            }
        }
    }
}
