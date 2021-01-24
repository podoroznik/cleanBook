package com.example.readbook.presentation.createFragment

import android.app.Activity
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.readbook.R
import com.example.readbook.domain.model.Book
import com.example.readbook.domain.usecase.SaveBookUseCase
import com.example.readbook.utils.Constants
import kotlinx.coroutines.launch

class CreateViewModel(val saveBookUseCase: SaveBookUseCase, val activity: Activity) : ViewModel() {


    fun navigateCreateToMain() {
        Navigation.findNavController(activity, R.id.nav_host_fragment)
            .navigate(CreateFragmentDirections.actionCreateFragmentToMainFragment())
    }


    fun saveBook(book: Book) {
        viewModelScope.launch {
            saveBookUseCase.saveBook(book)
        }
    }

    fun validateFields(
        authorName: EditText,
        bookName: EditText,
        bookRate: EditText,
        bookStory: EditText,
        bookType: EditText,
        bookAforismi: EditText,
        mainChars: EditText,
        bookMeaning: EditText,
        place: EditText,
        newWords: EditText,
        unknownWords: EditText,
        bookYear: EditText
    ): Boolean {
        return authorName.text.toString() == Constants.EMPTY_STRING ||
                bookName.text.toString() == Constants.EMPTY_STRING ||
                bookRate.text.toString() == Constants.EMPTY_STRING ||
                bookStory.text.toString() == Constants.EMPTY_STRING ||
                bookType.text.toString() == Constants.EMPTY_STRING ||
                bookAforismi.text.toString() == Constants.EMPTY_STRING ||
                mainChars.text.toString() == Constants.EMPTY_STRING ||
                bookMeaning.text.toString() == Constants.EMPTY_STRING ||
                place.text.toString() == Constants.EMPTY_STRING ||
                newWords.text.toString() == Constants.EMPTY_STRING ||
                unknownWords.text.toString() == Constants.EMPTY_STRING ||
                bookYear.text.toString() == Constants.EMPTY_STRING
    }

    fun getCurrentBook(
        authorName: String,
        bookName: String,
        bookRate: String,
        bookStory: String,
        bookType: String,
        bookAforismi: String,
        mainChars: String,
        bookMeaning: String,
        place: String,
        newWords: String,
        unknownWords: String,
        bookYear: String
    ): Book {
        val currentBook = Book()
        currentBook.bookAuthor = authorName
        currentBook.bookName = bookName
        currentBook.bookRate = bookRate
        currentBook.bookStory = bookStory
        currentBook.bookType = bookType
        currentBook.bookAforismi = bookAforismi
        currentBook.bookMainCharacters = mainChars
        currentBook.bookMeaning = bookMeaning
        currentBook.bookPlace = place
        currentBook.bookNewWords = newWords
        currentBook.bookUnknownWords = unknownWords
        currentBook.bookYears = bookYear
        return currentBook
    }
}
