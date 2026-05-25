package com.example.textbookstoreapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.textbookstoreapp.R
import com.example.textbookstoreapp.databinding.ActivityEnquiryBinding

class EnquiryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnquiryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_enquiry)

        val bookTitle = intent.getStringExtra("BOOK_TITLE") ?: "Unknown Book"
        binding.tvEnquiryHeader.text = "Enquiry for: $bookTitle"

        binding.btnSendMessage.setOnClickListener {
            val message = binding.etUserMessage.text.toString()
            if (message.isBlank()) {
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Message sent to seller!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}