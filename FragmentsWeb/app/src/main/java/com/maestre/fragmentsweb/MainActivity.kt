package com.maestre.fragmentsweb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){v,insets ->
            val insetsWindow = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(insetsWindow.left,insetsWindow.top,insetsWindow.right,insetsWindow.bottom)
            insets
        }

    }
}