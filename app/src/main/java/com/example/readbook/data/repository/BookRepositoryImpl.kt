package com.example.readbook.data.repository

import android.app.VoiceInteractor
import com.example.readbook.data.database.BookDatabseDao
import com.example.readbook.domain.model.Book
import com.example.readbook.domain.repository.BookRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class BookRepositoryImpl(val bookDatabseDao: BookDatabseDao) :
    BookRepository {

    override fun getBookById(id: Long): Single<Book> {
        return bookDatabseDao.get(id)
    }

    override fun deleteBookById(id: Long) {
        Completable.fromAction {
            bookDatabseDao.deleteByBookId(id)
        }.subscribeOn(Schedulers.io())
            .subscribe({}, {})
    }

    override fun saveBook(book: Book) {
        Completable.fromAction {
            bookDatabseDao.insert(book)
        }.subscribeOn(Schedulers.io())
            .subscribe({}, {})

    }

    override fun getAllBooks(): Single<List<Book>> {
        return bookDatabseDao.getAllBooks()
    }
}