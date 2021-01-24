package com.example.readbook.presentation.deleteFragment

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.readbook.R
import com.example.readbook.domain.usecase.DeleteBookByIdUseCase
import kotlinx.coroutines.launch

class DeleteViewModel(val deleteBookByIdUseCase: DeleteBookByIdUseCase, val activity: Activity) : ViewModel() {

    fun delete(id: Long) {
        viewModelScope.launch {
            deleteBookByIdUseCase.delete(id)
        }
    }

    fun validateCurrentDestination(currentDestination: Int?): Boolean {
        return currentDestination == R.id.deleteFragment
    }

    fun navigateToMain() {
        Navigation
            .findNavController(activity, R.id.nav_host_fragment)
            .navigate(DeleteFragmentDirections.actionDeleteFragmentToMainFragment())
    }
}