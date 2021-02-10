package com.example.readbook.domain.usecase

import com.example.readbook.domain.model.Book
import com.example.readbook.domain.repository.BookRepository
import io.reactivex.Flowable
import io.reactivex.Single


class GetBookByIdUseCase(val repository: BookRepository) {

    fun getBook(bookId: Long) : Single<Book> = repository.getBookById(bookId)
}