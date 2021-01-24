package com.example.readbook.domain.usecase

import com.example.readbook.domain.model.Book
import com.example.readbook.domain.repository.BookRepository

class SaveBookUseCase(val repository: BookRepository) {

    suspend fun saveBook(book : Book){
        repository.saveBook(book)
    }

}