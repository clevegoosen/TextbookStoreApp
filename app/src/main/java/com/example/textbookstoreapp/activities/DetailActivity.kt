package com.example.textbookstoreapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.textbookstoreapp.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("BOOK_TITLE") ?: "Book Title"
        val price = intent.getStringExtra("BOOK_PRICE") ?: "R0"

        findViewById<TextView>(R.id.tvDetailTitle).text = title
        findViewById<TextView>(R.id.tvDetailPrice).text = price

        findViewById<Button>(R.id.btnEnquire).setOnClickListener {
            val intent = Intent(this, EnquiryActivity::class.java)
            startActivity(intent)
        }
    }
}