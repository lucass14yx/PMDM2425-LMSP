package com.maestre.wisdompills

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maestre.wisdompills.databinding.ActivityRegisterActivityBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}