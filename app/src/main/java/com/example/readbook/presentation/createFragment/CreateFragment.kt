package com.example.readbook.presentation.createFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.readbook.presentation.MainActivity
import com.example.readbook.R
import com.example.readbook.databinding.FragmentCreateBinding
import com.example.readbook.di.components.DaggerCreateFragmentComponent
import javax.inject.Inject


class CreateFragment : Fragment() {

    @Inject
    lateinit var factory: CreateViewModelFactory

    lateinit var viewModel : CreateViewModel
    lateinit var binding : FragmentCreateBinding

            override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val appComponent = (activity as MainActivity).activityComponent

        activity?.let {
            DaggerCreateFragmentComponent.builder().activityComponent(
                appComponent
            ).build().inject(this)
        }
         binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_create, container, false)

         viewModel = ViewModelProvider(this, factory).get(CreateViewModel::class.java)



        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.saveButton.setOnClickListener {
            if (viewModel.validateFields(
                    binding.authorName,
                    binding.bookName,
                    binding.bookRate,
                    binding.bookStory,
                    binding.bookType,
                    binding.bookAforismi,
                    binding.mainChars,
                    binding.bookMeaning,
                    binding.place,
                    binding.newWords,
                    binding.unknownWords,
                    binding.bookYear
                )
            ) {
                val toast = Toast.makeText(
                    this.context,
                    resources.getString(R.string.full_all_fields),
                    Toast.LENGTH_SHORT
                )
                toast.show()
                return@setOnClickListener
            }
            viewModel.saveBook(
                viewModel.getCurrentBook(
                    binding.authorName.text.toString(),
                    binding.bookName.text.toString(),
                    binding.bookRate.text.toString(),
                    binding.bookStory.text.toString(),
                    binding.bookType.text.toString(),
                    binding.bookAforismi.text.toString(),
                    binding.mainChars.text.toString(),
                    binding.bookMeaning.text.toString(),
                    binding.place.text.toString(),
                    binding.newWords.text.toString(),
                    binding.unknownWords.text.toString(),
                    binding.bookYear.text.toString()
                )
            )
            viewModel.navigateCreateToMain()
        }

    }
}
