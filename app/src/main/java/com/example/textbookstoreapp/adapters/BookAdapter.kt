package com.example.textbookstoreapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.textbookstoreapp.activities.DetailActivity
import com.example.textbookstoreapp.databinding.ItemBookBinding
import com.example.textbookstoreapp.models.Book

class BookAdapter(private var bookList: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.book = book
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(com.example.textbookstoreapp.R.layout.item_book, parent, false)
        val binding = ItemBookBinding.bind(layoutInflater)
        return BookViewHolder(binding)
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.bind(book)
        holder.binding.ivBookItem.setImageResource(book.imageResId)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("BOOK_TITLE", book.title)
            intent.putExtra("BOOK_AUTHOR", book.author)
            intent.putExtra("BOOK_EDITION", book.edition)
            intent.putExtra("BOOK_PRICE", book.price)
            intent.putExtra("BOOK_DESCRIPTION", book.description)
            intent.putExtra("BOOK_IMAGE", book.imageResId)
            holder.itemView.context.startActivity(intent)
        }
    }

    fun updateData(newList: List<Book>) {
        bookList = newList
        notifyDataSetChanged()
    }
}