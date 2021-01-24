package com.example.readbook.presentation.deleteFragment

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.readbook.domain.usecase.DeleteBookByIdUseCase


class DeleteViewModelFactory(val deleteBookByIdUseCase: DeleteBookByIdUseCase, val activity: Activity) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeleteViewModel::class.java)) {
            return DeleteViewModel(deleteBookByIdUseCase, activity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}