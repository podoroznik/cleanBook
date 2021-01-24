package com.example.readbook.presentation.createFragment

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.readbook.domain.usecase.SaveBookUseCase

class CreateViewModelFactory(val saveBookUseCase: SaveBookUseCase, val activity: Activity) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateViewModel::class.java)) {
            return CreateViewModel(saveBookUseCase, activity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
