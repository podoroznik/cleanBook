package com.example.readbook.di.components

import android.app.Activity
import androidx.navigation.NavController
import com.example.readbook.data.database.BookDatabseDao
import com.example.readbook.di.modules.ActivityModule
import com.example.readbook.di.modules.UseCaseModule
import com.example.readbook.di.scopes.ActivityScope
import com.example.readbook.domain.usecase.DeleteBookByIdUseCase
import com.example.readbook.domain.usecase.GetAllBooksUseCase
import com.example.readbook.domain.usecase.GetBookByIdUseCase
import com.example.readbook.domain.usecase.SaveBookUseCase
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class,UseCaseModule::class])
interface ActivityComponent {
    fun navController() : NavController
    fun database() : BookDatabseDao
    fun activity() : Activity
    fun getAllBooksUseCase(): GetAllBooksUseCase
    fun getBookByIdUseCase(): GetBookByIdUseCase
    fun saveBookUseCase(): SaveBookUseCase
    fun deleteBookByIdUseCase(): DeleteBookByIdUseCase
}