package com.example.textbookstoreapp.activities

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.textbookstoreapp.R
import com.example.textbookstoreapp.adapters.BookAdapter
import com.example.textbookstoreapp.models.Book

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: BookAdapter
    private val books = listOf(
        Book("Maths 101", "R300"),
        Book("Android Dev", "R450"),
        Book("Physics Guide", "R350"),
        Book("African Literature", "R250"),
        Book("Economics SA", "R550")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val etSearch = findViewById<EditText>(R.id.etSearch)

        adapter = BookAdapter(books)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        etSearch.addTextChangedListener {
            val query = it.toString()
            val filtered = books.filter { book ->
                book.title.contains(query, ignoreCase = true)
            }
            adapter.updateData(filtered)
        }
    }
}