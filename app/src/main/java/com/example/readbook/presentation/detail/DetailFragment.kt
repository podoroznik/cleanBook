package com.example.readbook.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.readbook.R
import com.example.readbook.databinding.DetailFragmentBinding
import com.example.readbook.di.components.DaggerDetailFragmentComponent
import com.example.readbook.di.modules.DetailFragmentModule
import com.example.readbook.domain.usecase.GetBookByIdUseCase
import com.example.readbook.presentation.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var navController: NavController

    @Inject
    lateinit var factory: DetailViewModelFactory

    @Inject
    lateinit var getBookByIdUseCase: GetBookByIdUseCase


    lateinit var viewModel: DetailViewModel
    lateinit var binding: DetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        val arguments = DetailFragmentArgs.fromBundle(arguments)

        val appComponent = (activity as MainActivity).activityComponent

        activity?.let {
            DaggerDetailFragmentComponent.builder().activityComponent(
                appComponent
            ).detailFragmentModule(
                DetailFragmentModule(arguments.bookKey)
            ).build().inject(this)
        }

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = viewModel
        viewModel.currentBook.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ binding.book = it }, {})


        viewModel.onShareClicked.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                viewModel.currentBook.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val book = it
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(
                            Intent.EXTRA_TEXT, "Автор:${book.bookAuthor}\n" +
                                    "Название книги: ${book.bookName}\n" +
                                    "Жанр: ${book.bookType}\n" +
                                    "Год написания: ${book.bookYears}\n" +
                                    "Место действия: ${book.bookPlace}\n" +
                                    "Главные персонажи: ${book.bookMainCharacters}\n" +
                                    "Фабула: ${book.bookStory}\n" +
                                    "Смысл: ${book.bookMeaning}\n" +
                                    "Оценка: ${book.bookRate}\n" +
                                    "Авторские афоризмы: ${book.bookAforismi}\n" +
                                    "Незнакомые слова: ${book.bookUnknownWords}\n" +
                                    "Новые слова: ${book.bookNewWords}\n"
                        )
                        startActivity(intent)
                    }, {})
            }
        })

        viewModel.navigateToDelete.observe(viewLifecycleOwner, Observer {

            if (viewModel.validateDestination(navController.currentDestination?.id)) {
                viewModel.currentBook.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        it.bookId.let { id -> viewModel.navigateToDelete(id) }
                    }, {})
            }
        })

    }
}