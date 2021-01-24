package com.example.readbook.di.modules

import android.app.Activity
import com.example.readbook.presentation.deleteFragment.DeleteViewModelFactory
import com.example.readbook.di.scopes.FragmentScope
import com.example.readbook.domain.usecase.DeleteBookByIdUseCase
import dagger.Module
import dagger.Provides

@Module
class DeleteFragmentModule {

    @FragmentScope
    @Provides
    fun provideDetailViewModelFactory(
        deleteBookByIdUseCase: DeleteBookByIdUseCase,
        activity: Activity
    ): DeleteViewModelFactory {
        return DeleteViewModelFactory(deleteBookByIdUseCase, activity)
    }
}