package com.example.readbook.domain.usecase

import com.example.readbook.domain.repository.BookRepository


class DeleteBookByIdUseCase(val repository: BookRepository) {

    suspend fun delete(id:Long){
        repository.deleteBookById(id)
    }

}