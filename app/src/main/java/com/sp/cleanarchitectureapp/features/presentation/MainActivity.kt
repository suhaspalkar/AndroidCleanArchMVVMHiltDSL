package com.sp.cleanarchitectureapp.features.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sp.cleanarchitectureapp.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped

@AndroidEntryPoint
@ActivityScoped
class MainActivity : AppCompatActivity() {

    private lateinit var _mainActivityBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(_mainActivityBinding.root)

    }

}