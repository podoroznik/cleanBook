package com.example.readbook.presentation.mainFragment

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.readbook.domain.usecase.GetAllBooksUseCase


class MainViewModelFactory(
    private val getAllBooksUseCase: GetAllBooksUseCase,
    private val activity: Activity
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getAllBooksUseCase, activity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}