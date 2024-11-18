package com.maestre.wisdompills

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maestre.wisdompills.databinding.ActivityOtherBinding


class OtherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}