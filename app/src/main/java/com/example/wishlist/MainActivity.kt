package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var listItems: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listRv = findViewById<RecyclerView>(R.id.listRv)
        listItems = ListFetcher.getItems()

        val adapter = WishListAdapter(listItems)

        listRv.adapter = adapter

        listRv.layoutManager = LinearLayoutManager(this)

        val addButton = findViewById<Button>(R.id.addButton)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val priceInput = findViewById<EditText>(R.id.priceInput)
        val urlInput = findViewById<EditText>(R.id.urlInput)

        addButton.setOnClickListener {
            if (nameInput.text.toString().isNotEmpty() &&
                priceInput.text.toString().isNotEmpty() &&
                urlInput.text.toString().isNotEmpty()) {
                val item = Item(nameInput.text.toString(), priceInput.text.toString().toDouble(), urlInput.text.toString() )
                ListFetcher.addItem(item)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}