package com.example.readbook.di.modules

import android.app.Activity
import com.example.readbook.presentation.createFragment.CreateViewModelFactory
import com.example.readbook.di.scopes.FragmentScope
import com.example.readbook.domain.usecase.SaveBookUseCase
import dagger.Module
import dagger.Provides

@Module
class CreateFragmentModule() {
    
    @FragmentScope
    @Provides
    fun provideCreateViewModelFactory(
        activity: Activity,
        saveBookUseCase: SaveBookUseCase
    ): CreateViewModelFactory {
        return CreateViewModelFactory(saveBookUseCase, activity)
    }
}