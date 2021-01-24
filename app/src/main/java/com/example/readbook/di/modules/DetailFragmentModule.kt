package com.example.readbook.di.modules

import android.app.Activity
import com.example.readbook.presentation.detail.DetailViewModelFactory
import com.example.readbook.di.scopes.FragmentScope
import com.example.readbook.domain.usecase.GetBookByIdUseCase
import dagger.Module
import dagger.Provides

@Module
class DetailFragmentModule(private val key: Long) {

    @FragmentScope
    @Provides
    fun provideDetailViewModelFactory(
        getBookByIdUseCase : GetBookByIdUseCase,
        activity: Activity,
        key: Long
    ): DetailViewModelFactory {
        return DetailViewModelFactory(getBookByIdUseCase, key, activity)
    }

    @FragmentScope
    @Provides
    fun provideKey(): Long {
        return key
    }
}