package com.example.listviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //test chuyển màu cho List View
        val mauXanh = Color.parseColor("#FF00FF00")
        binding.listView.setBackgroundColor(mauXanh)
        addEvents()
    }

    private fun addEvents() {
        hienThiLvCountries()
    }
    private fun hienThiLvCountries() {
        //Khai báo array sử dụng resources trong file strings.xml
        var arrayCountry = resources.getStringArray(R.array.arrCountry)
        //Khai báo adapter và gán nguồn chop adapter
        binding.listView.adapter = ArrayAdapter(
            this, // màn hình activity hiện tại de gọi adapter
            android.R.layout.simple_list_item_1, //vẻ giao diện cho từng dòng có sẵn trong android
            arrayCountry //nguon dữ liệu gán cho adapter
        )
        binding.listView.setOnItemClickListener { parent, view, position, id ->
          Toast.makeText(this, "Bạn chọn: ${arrayCountry[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}