package com.example.readbook.di.modules

import com.example.readbook.di.scopes.ActivityScope
import com.example.readbook.domain.repository.BookRepository
import com.example.readbook.domain.usecase.DeleteBookByIdUseCase
import com.example.readbook.domain.usecase.GetAllBooksUseCase
import com.example.readbook.domain.usecase.GetBookByIdUseCase
import com.example.readbook.domain.usecase.SaveBookUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {
    @ActivityScope
    @Provides
    fun provideGetAllBooksUseCase(repository: BookRepository): GetAllBooksUseCase {
        return GetAllBooksUseCase(repository)
    }

    @ActivityScope
    @Provides
    fun provideGetBookByIdUseCase(repository: BookRepository): GetBookByIdUseCase {
        return GetBookByIdUseCase(repository)
    }

    @ActivityScope
    @Provides
    fun provideSaveBookUseCase(repository: BookRepository): SaveBookUseCase {
        return SaveBookUseCase(repository)
    }

    @ActivityScope
    @Provides
    fun provideDeleteBookByIdUseCase(repository: BookRepository): DeleteBookByIdUseCase{
        return DeleteBookByIdUseCase(repository)
    }
}