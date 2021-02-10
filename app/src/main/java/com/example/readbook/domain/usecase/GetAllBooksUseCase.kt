package com.example.readbook.domain.usecase

import com.example.readbook.domain.model.Book
import com.example.readbook.domain.repository.BookRepository
import io.reactivex.Single

class GetAllBooksUseCase(val repository: BookRepository) {
    fun getAllBooks(): Single<List<Book>> = repository.getAllBooks()
}