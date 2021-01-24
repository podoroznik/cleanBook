package com.example.readbook.domain.usecase

import androidx.lifecycle.LiveData
import com.example.readbook.domain.model.Book
import com.example.readbook.domain.repository.BookRepository

class GetAllBooksUseCase(val repository: BookRepository) {
    fun getAllBooks() : LiveData<List<Book>> = repository.getAllBooks()
}