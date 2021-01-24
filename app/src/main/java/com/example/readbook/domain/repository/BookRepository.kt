package com.example.readbook.domain.repository

import androidx.lifecycle.LiveData
import com.example.readbook.domain.model.Book

interface BookRepository {

    fun getBookById(id : Long) : LiveData<Book>

    suspend fun deleteBookById(id : Long)

    suspend fun saveBook(book: Book)

    fun getAllBooks(): LiveData<List<Book>>
}