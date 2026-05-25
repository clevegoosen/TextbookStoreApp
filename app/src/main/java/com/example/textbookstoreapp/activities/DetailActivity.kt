package com.example.textbookstoreapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.textbookstoreapp.R
import com.example.textbookstoreapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val title = intent.getStringExtra("BOOK_TITLE") ?: "N/A"
        val author = intent.getStringExtra("BOOK_AUTHOR") ?: "N/A"
        val edition = intent.getStringExtra("BOOK_EDITION") ?: "N/A"
        val price = intent.getStringExtra("BOOK_PRICE") ?: "N/A"
        val description = intent.getStringExtra("BOOK_DESCRIPTION") ?: "No description available."
        val imageResId = intent.getIntExtra("BOOK_IMAGE", R.drawable.ic_launcher_background)

        binding.tvDetailTitle.text = title
        binding.tvDetailAuthor.text = author
        binding.tvDetailEdition.text = "Edition: $edition"
        binding.tvDetailPrice.text = price
        binding.tvDetailDescription.text = description
        binding.ivBookDetail.setImageResource(imageResId)

        binding.btnContactSeller.setOnClickListener {
            val intent = Intent(this, EnquiryActivity::class.java)
            intent.putExtra("BOOK_TITLE", title)
            startActivity(intent)
        }
    }
}