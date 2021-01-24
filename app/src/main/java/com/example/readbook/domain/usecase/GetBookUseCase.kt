package com.example.readbook.domain.usecase

import com.example.readbook.domain.repository.BookRepository


class GetBookByIdUseCase(val repository: BookRepository) {

    fun getBook(bookId: Long) = repository.getBookById(bookId)

}