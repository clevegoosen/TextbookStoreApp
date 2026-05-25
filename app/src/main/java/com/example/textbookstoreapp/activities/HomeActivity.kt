package com.example.textbookstoreapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.textbookstoreapp.R
import com.example.textbookstoreapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnSearchBooks.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        binding.btnListBook.setOnClickListener {
            startActivity(Intent(this, ListBookActivity::class.java))
        }

        binding.btnMessages.setOnClickListener {
            startActivity(Intent(this, MessagesActivity::class.java))
        }
    }
}