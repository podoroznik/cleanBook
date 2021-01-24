package com.example.readbook.di.components

import com.example.readbook.presentation.createFragment.CreateFragment
import com.example.readbook.di.modules.CreateFragmentModule
import com.example.readbook.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [CreateFragmentModule::class])
interface CreateFragmentComponent {
    fun inject(createFragment: CreateFragment)
}