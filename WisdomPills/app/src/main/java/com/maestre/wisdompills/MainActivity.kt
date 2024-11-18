package com.maestre.wisdompills

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maestre.wisdompills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOther.setOnClickListener{
            val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        }
        binding.btnEnter.setOnClickListener{
            val intent = Intent(this, EnterActivity::class.java)
            startActivity(intent)
        }

    }

}