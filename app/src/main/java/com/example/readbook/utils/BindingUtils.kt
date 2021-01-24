package com.example.readbook.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.readbook.domain.model.Book

@BindingAdapter("BookName")
fun TextView.setBookName(item: Book?) {
    item?.let {
        text = item.bookName
    }
}