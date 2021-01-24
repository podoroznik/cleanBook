package com.example.readbook.di.components

import com.example.readbook.di.modules.MainFragmentModule
import com.example.readbook.di.modules.UseCaseModule
import com.example.readbook.presentation.mainFragment.MainFragment
import com.example.readbook.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [MainFragmentModule::class])
interface MainFragmentComponent {
    fun inject(fragment: MainFragment)
}