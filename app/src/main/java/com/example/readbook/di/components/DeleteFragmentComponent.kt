package com.example.readbook.di.components

import com.example.readbook.presentation.deleteFragment.DeleteFragment
import com.example.readbook.di.modules.DeleteFragmentModule
import com.example.readbook.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [DeleteFragmentModule::class])
interface DeleteFragmentComponent {
    fun inject(deleteFragment: DeleteFragment)
}