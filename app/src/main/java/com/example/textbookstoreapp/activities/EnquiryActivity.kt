package com.example.textbookstoreapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.textbookstoreapp.R

class EnquiryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enquiry)

        val etName = findViewById<EditText>(R.id.etStudentName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitEnquiry)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            if (name.isEmpty()) {
                etName.error = "Required"
            } else {
                Toast.makeText(this, "Enquiry submitted!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}