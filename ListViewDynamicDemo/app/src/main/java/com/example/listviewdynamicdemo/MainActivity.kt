package com.example.listviewdynamicdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listviewdynamicdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //khai báo List rỗng
    var ds: MutableList<String> = mutableListOf("0939245678", "0987122345")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //hiển thi danh sach số điện thoại ban đầu
        binding.lvTen.adapter =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ds)
        addEvents()
    }

    private fun addEvents() {
       binding.btnLuu.setOnClickListener {
                hamXuLiLuuData()
            }
    }

    private fun hamXuLiLuuData() {
            var s:String = binding.edtTen.text.toString()
            ds.add(s)
            binding.edtTen.setText("") // xóa trắng ô nhập liệu
            //cập nhật lại giao diện
            binding.lvTen.adapter =
                ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ds)

    }
}