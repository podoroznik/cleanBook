package com.example.readbook.presentation.detail

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.readbook.R
import com.example.readbook.domain.usecase.GetBookByIdUseCase

class DetailViewModel(val getBookByIdUseCase: GetBookByIdUseCase, val id: Long, val activity: Activity) :
    ViewModel() {

    private val _navigateToDelete = MutableLiveData<Boolean>()

    val navigateToDelete: LiveData<Boolean>
        get() = _navigateToDelete


    private val _onShareClicked = MutableLiveData<Boolean>()

    val onShareClicked: LiveData<Boolean>
        get() = _onShareClicked

    val currentBook = getBookByIdUseCase.getBook(id)


    fun onClick() {
        _navigateToDelete.value = true
    }

    fun onShareClicked() {
        _onShareClicked.value = true
    }


    fun validateDestination(id: Int?): Boolean {
        return id == R.id.detailFragment
    }

    fun navigateToDelete(id: Long) {
        Navigation
            .findNavController(activity, R.id.nav_host_fragment)
            .navigate(DetailFragmentDirections.actionDetailFragmentToDeleteFragment(id))
    }


}