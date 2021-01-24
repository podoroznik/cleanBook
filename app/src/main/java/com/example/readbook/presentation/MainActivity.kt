package com.example.readbook.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.readbook.R
import com.example.readbook.di.components.ActivityComponent
import com.example.readbook.di.components.DaggerActivityComponent
import com.example.readbook.di.modules.ActivityModule


class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build()
        setContentView(R.layout.activity_main)
    }
}