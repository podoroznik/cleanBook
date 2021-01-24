package com.example.readbook.presentation.detail


import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.readbook.domain.usecase.GetBookByIdUseCase

class DetailViewModelFactory(
    val getBookByIdUseCase: GetBookByIdUseCase,
    val bookId: Long,
    val activity: Activity
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(getBookByIdUseCase, bookId, activity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
