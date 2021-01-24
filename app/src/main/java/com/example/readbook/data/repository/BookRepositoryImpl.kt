package com.example.readbook.data.repository

import androidx.lifecycle.LiveData
import com.example.readbook.domain.model.Book
import com.example.readbook.data.database.BookDatabseDao
import com.example.readbook.domain.repository.BookRepository

class BookRepositoryImpl(val bookDatabseDao: BookDatabseDao) :
    BookRepository {

    override fun getBookById(id: Long): LiveData<Book> {
        return bookDatabseDao.get(id)
    }

    override suspend fun deleteBookById(id: Long) {
        bookDatabseDao.deleteByBookId(id)
    }

    override suspend fun saveBook(book: Book) {
        bookDatabseDao.insert(book)
    }

    override fun getAllBooks(): LiveData<List<Book>> {
        return bookDatabseDao.getAllBooks()
    }
}