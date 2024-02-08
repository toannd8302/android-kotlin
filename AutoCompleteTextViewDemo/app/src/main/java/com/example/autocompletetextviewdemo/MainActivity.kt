package com.example.autocompletetextviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.autocompletetextviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Khai báo List 64 tỉnh thành
        val list = resources.getStringArray(R.array.tinhthanh)
        val adt = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.autoTinhThanh.setAdapter(adt)
        binding.autoTinhThanh.setOnFocusChangeListener({ view, b ->
            if (binding.autoTinhThanh.text.isEmpty()) {
                binding.autoTinhThanh.showDropDown()
            }
        })
        //Kiểm tra item nào được chọn
        binding.autoTinhThanh.setOnItemClickListener { adapterView, view, i, l ->
          Toast.makeText(this, "Bạn đã chọn: ${binding.autoTinhThanh.text}", Toast.LENGTH_SHORT).show()
        }
    }

    //Gợi ý với 0 kí tự
}