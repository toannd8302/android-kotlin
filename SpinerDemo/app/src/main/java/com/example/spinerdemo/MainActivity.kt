package com.example.spinerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //test spinner
        setupSpinner()
    }

    private fun setupSpinner() {
        //tạo 1 list NGon NGu
        val list = resources.getStringArray(R.array.app_language)
        //tạo adapter => điều hướng
        val adt = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        //gọi spinner
        binding.spNgonNgu.adapter = adt

        //onitemselected
        binding.spNgonNgu.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Bạn chọn: ${list[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Bạn chưa chọn gì cả", Toast.LENGTH_SHORT).show()
            }
        }
    }
}