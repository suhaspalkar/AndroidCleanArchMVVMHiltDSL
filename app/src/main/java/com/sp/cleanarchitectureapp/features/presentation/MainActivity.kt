package com.sp.cleanarchitectureapp.features.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sp.cleanarchitectureapp.R
import com.sp.cleanarchitectureapp.databinding.MainActivityBinding
import com.sp.cleanarchitectureapp.features.presentation.todos.TodosFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _mainActivityBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(_mainActivityBinding.root)

    }

}