package com.example.readbook.domain.repository

import com.example.readbook.domain.model.Book
import io.reactivex.Flowable
import io.reactivex.Single

interface BookRepository {

    fun getBookById(id: Long): Single<Book>

    fun deleteBookById(id: Long)

    fun saveBook(book: Book)

    fun getAllBooks(): Single<List<Book>>
}