package com.example.spinnercustomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spinnercustomdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //tạo hàm customSpinner
        setupCustomSpinner()
    }

    private fun setupCustomSpinner() {
        var list2 = mutableListOf<OutData>()
        list2.add(OutData(R.drawable.baseline_lock_24, "Khóa"))
        list2.add(OutData(R.drawable.baseline_person_24, "Người"))
        binding.spinner.adapter = CustomSpinner(this, list2)
    }
}