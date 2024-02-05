package com.example.imageview_imagebuttondemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageview_imagebuttondemo.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Hàm add Event
        addEvents()
    }

    private fun addEvents() {
        binding.radPic1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
            {
                binding.imgImage.setImageResource(R.drawable.bidao)
            }
            binding.radPic2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                {
                    binding.imgImage.setImageResource(R.drawable.carot)
                }
            }
            binding.btnExit.setOnClickListener {
                finish()
            }
        }
    }
}