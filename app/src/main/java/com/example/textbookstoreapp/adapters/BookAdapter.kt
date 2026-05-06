package com.example.textbookstoreapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.textbookstoreapp.R
import com.example.textbookstoreapp.activities.DetailActivity
import com.example.textbookstoreapp.models.Book

class BookAdapter(private var bookList: List<Book>) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val price = view.findViewById<TextView>(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bookList[position]
        holder.title.text = book.title
        holder.price.text = book.price

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("BOOK_TITLE", book.title)
            intent.putExtra("BOOK_PRICE", book.price)
            holder.itemView.context.startActivity(intent)
        }
    }

    fun updateData(newList: List<Book>) {
        bookList = newList
        notifyDataSetChanged()
    }
}