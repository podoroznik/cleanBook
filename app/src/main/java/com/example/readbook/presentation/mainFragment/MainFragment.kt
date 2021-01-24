package com.example.readbook.presentation.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readbook.presentation.MainActivity
import com.example.readbook.R
import com.example.readbook.databinding.MainFragmentBinding
import com.example.readbook.di.components.DaggerMainFragmentComponent
import com.example.readbook.domain.usecase.GetAllBooksUseCase
import javax.inject.Inject


class MainFragment : Fragment() {
    @Inject
    lateinit var factory: MainViewModelFactory

    @Inject
    lateinit var navController: NavController

    @Inject
    lateinit var getAllBooksUseCase: GetAllBooksUseCase

    lateinit var viewModel : MainViewModel

    lateinit var binding : MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val appComponent = (activity as MainActivity).activityComponent

        activity?.let {
            DaggerMainFragmentComponent.builder()
                .activityComponent(appComponent).build()
                .inject(this)
        }
        binding =
            DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = BookAdapter(BookListener { book ->
            viewModel.onBookClicked(book)
        })

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.bookList.adapter = adapter

        viewModel.navigateToCreate.observe(viewLifecycleOwner, Observer {
            if (viewModel.validateDestination(navController.currentDestination?.id)) {
                viewModel.navigateToCreate()
            }
        })


        viewModel.books.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (viewModel.validateDestination(navController.currentDestination?.id)) {
                    viewModel.navigateToDetail(it)
                }
            }
        })

        val manager = LinearLayoutManager(context)
        binding.bookList.layoutManager = manager
    }
}