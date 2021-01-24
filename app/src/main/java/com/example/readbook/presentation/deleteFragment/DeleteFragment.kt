package com.example.readbook.presentation.deleteFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.readbook.presentation.MainActivity
import com.example.readbook.R
import com.example.readbook.databinding.FragmentDeleteBinding
import com.example.readbook.di.components.DaggerDeleteFragmentComponent
import javax.inject.Inject


class DeleteFragment : Fragment() {

    @Inject
    lateinit var factory: DeleteViewModelFactory

    @Inject
    lateinit var navController: NavController


    lateinit var viewModel : DeleteViewModel
    lateinit var binding : FragmentDeleteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val appComponent = (activity as MainActivity).activityComponent


        activity?.let {
            DaggerDeleteFragmentComponent.builder().activityComponent(
              appComponent
            ).build().inject(this)
        }

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_delete, container, false
        )


        viewModel = ViewModelProvider(this, factory).get(DeleteViewModel::class.java)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val id = DeleteFragmentArgs.fromBundle(arguments).bookKey

        binding.noButton.setOnClickListener {
            navController.popBackStack()
        }

        binding.yesButton.setOnClickListener {
            viewModel.delete(id)
            if (viewModel.validateCurrentDestination(navController.currentDestination?.id)) {
                viewModel.navigateToMain()
            }
        }

    }
}