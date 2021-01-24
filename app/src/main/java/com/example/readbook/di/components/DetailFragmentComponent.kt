package com.example.readbook.di.components

import com.example.readbook.presentation.detail.DetailFragment
import com.example.readbook.di.modules.DetailFragmentModule
import com.example.readbook.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [DetailFragmentModule::class])
interface DetailFragmentComponent {
    fun inject(fragment: DetailFragment)
}