package com.example.readbook.di.modules

import android.app.Activity
import com.example.readbook.presentation.mainFragment.MainViewModelFactory
import com.example.readbook.di.scopes.FragmentScope
import com.example.readbook.domain.usecase.GetAllBooksUseCase
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule {

    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        useCase: GetAllBooksUseCase,
        activity: Activity
    ): MainViewModelFactory {
        return MainViewModelFactory(useCase, activity)
    }
}