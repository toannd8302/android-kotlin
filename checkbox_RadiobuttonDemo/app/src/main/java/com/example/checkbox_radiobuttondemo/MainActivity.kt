package com.example.checkbox_radiobuttondemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.checkbox_radiobuttondemo.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //khai báo đồng bộ View với UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addEvent()
    }

    private fun addEvent() {
        //Xử lí sự kiện khi chọn nút Chọn Sở Thích
        binding.btnChonSoThich.setOnClickListener {
            xuLiChonSuThich()
        }

        //Xử lí sự kiện nút Xác nhận
        binding.btnXacNhan.setOnClickListener {
            xuLiXacNhan()
        }
    }

    private fun xuLiXacNhan() {
        var s: String = ""
        if (binding.radNam.isChecked)
            s = binding.radNam.text.toString()
        else if (binding.radNu.isChecked)
            s = binding.radNu.text.toString()
        //gán chuổi s vào edtXacNhanGioiTInh

        //Thông báo chuỗi s
        if (s == ""){
            binding.edtXacNhanGioiTInh.setText("Bạn chưa chọn giới tính!!!")
            Toast.makeText(this, "Bạn chưa chọn giới tính!!!", Toast.LENGTH_SHORT).show()
        }
        else {
            binding.edtXacNhanGioiTInh.setText(s)

            Toast.makeText(this, "Bạn đã chọn giới tính " + s, Toast.LENGTH_SHORT).show()
        }

    }

    private fun xuLiChonSuThich() {
        var s: String = ""
        if (binding.chkMusic.isChecked)
            s += binding.chkMusic.text.toString() + "\n"
        if (binding.chkMovie.isChecked)
            s += binding.chkMovie.text.toString() + "\n"
        if (binding.chkSport.isChecked)
            s += binding.chkSport.text.toString() + "\n"
        if (binding.chkShopping.isChecked)
            s += binding.chkShopping.text.toString() + "\n"
        if (binding.chklTravel.isChecked)
            s += binding.chklTravel.text.toString() + "\n"

        //gán vào ô edtSoThich
        binding.edtSoThich.setText(s)
    }
}