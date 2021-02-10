package com.example.readbook.presentation.mainFragment

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.readbook.R
import com.example.readbook.domain.model.Book
import com.example.readbook.domain.usecase.GetAllBooksUseCase
import io.reactivex.Single


class MainViewModel(val getAllBooksUseCase: GetAllBooksUseCase, val activity: Activity) :
    ViewModel() {

    private val _navigateToDetail = MutableLiveData<Long>()
    val books: Single<List<Book>> = getAllBooksUseCase.getAllBooks()
    val navigateToDetail: LiveData<Long>
        get() = _navigateToDetail


    private val _navigateToCreate = MutableLiveData<Boolean>()

    val navigateToCreate: LiveData<Boolean>
        get() = _navigateToCreate


    fun onClick() {
        _navigateToCreate.value = true
    }

    fun onBookClicked(bookId: Long) {
        _navigateToDetail.value = bookId
    }

    fun validateDestination(id: Int?): Boolean {
        return (id == R.id.mainFragment)
    }

    fun navigateToCreate() {
        Navigation
            .findNavController(activity, R.id.nav_host_fragment)
            .navigate(MainFragmentDirections.actionMainFragmentToCreateFragment())
    }

    fun navigateToDetail(id: Long) {
        Navigation
            .findNavController(activity, R.id.nav_host_fragment)
            .navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(id))
    }

}