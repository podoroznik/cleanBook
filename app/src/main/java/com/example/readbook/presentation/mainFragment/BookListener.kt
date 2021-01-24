package com.example.readbook.presentation.mainFragment

import com.example.readbook.domain.model.Book


class BookListener(val clickListener: (BookId: Long) -> Unit) {
    fun onClick(book: Book) = clickListener(book.bookId)
}