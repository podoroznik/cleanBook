package com.example.readbook.presentation.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.readbook.domain.model.Book
import com.example.readbook.databinding.BookItemBinding

class BookAdapter(val clickListener: BookListener) :
    ListAdapter<Book, BookAdapter.ViewHolder>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookItem = getItem(position)
        holder.bind(bookItem, clickListener)
    }

    class ViewHolder private constructor(val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book, clickListener: BookListener) {
            binding.book = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BookItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}



