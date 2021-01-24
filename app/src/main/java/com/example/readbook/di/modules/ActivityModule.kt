package com.example.readbook.di.modules

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.readbook.R
import com.example.readbook.data.database.BookDatabase
import com.example.readbook.data.database.BookDatabseDao
import com.example.readbook.data.repository.BookRepositoryImpl
import com.example.readbook.di.scopes.ActivityScope
import com.example.readbook.domain.repository.BookRepository
import dagger.Module
import dagger.Provides


@Module()
class ActivityModule(private val activity: Activity) {


    @ActivityScope
    @Provides
    fun provideRepository(database: BookDatabseDao): BookRepository {
        return BookRepositoryImpl(database)
    }


    @ActivityScope
    @Provides
    fun provideNavController(activity: Activity): NavController {
        return Navigation.findNavController(activity, R.id.nav_host_fragment)
    }

    @ActivityScope
    @Provides
    fun provideDatabase(activity: Activity): BookDatabseDao {
        return BookDatabase.getInstance(activity).bookDatabaseDao
    }

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return activity
    }


}