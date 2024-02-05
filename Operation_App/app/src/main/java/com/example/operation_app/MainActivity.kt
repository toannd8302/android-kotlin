package com.example.operation_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.operation_app.databinding.ActivityMainBinding
import java.lang.Exception
@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //khởi tạo viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //B1: Khai báo biến
//        val txtSoA: TextView = findViewById(R.id.txtSoA)
//        val txtSoB: TextView = findViewById(R.id.txtSoB)
//        val edtNhapSoA = findViewById<EditText>(R.id.edtNhapSoA)
//        val edtNhapSoB = findViewById<EditText>(R.id.edtNhapSoB)
//        val edtResult = findViewById<EditText>(R.id.edtResult)
//        //4 buttons
//        val btnCong = findViewById<Button>(R.id.btnCong)
//        val btnTru = findViewById<Button>(R.id.btnTru)
//        val btnNhan = findViewById<Button>(R.id.btnNhan)
//        val btnChia = findViewById<Button>(R.id.btnChia)
//        val btnLongClick = findViewById<Button>(R.id.btnLongClick)
//        val btnThoat = findViewById<Button>(R.id.btnThoat)
        //set event
       try {
           binding.btnCong.setOnClickListener {
               val soAInt = binding.edtNhapSoA.text.toString().toInt()
               val soBInt = binding.edtNhapSoB.text.toString().toInt()
               val result = soAInt + soBInt
               binding.edtResult.setText(result.toString())
           }
           binding.btnTru.setOnClickListener {
               val soAInt = binding.edtNhapSoA.text.toString().toInt()
               val soBInt = binding.edtNhapSoB.text.toString().toInt()
               val result = soAInt - soBInt
               binding.edtResult.setText(result.toString())
           }
           binding.btnNhan.setOnClickListener {
               val soAInt = binding.edtNhapSoA.text.toString().toInt()
               val soBInt = binding.edtNhapSoB.text.toString().toInt()
               val result = soAInt * soBInt
               binding.edtResult.setText(result.toString())
           }
           binding.btnChia.setOnClickListener {
               val soADouble = binding.edtNhapSoA.text.toString().toDouble()
               val soBDouble = binding.edtNhapSoB.text.toString().toDouble()

               if (soBDouble.toInt() == 0) {
                   Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show()
                   binding.edtResult.setText("Không thể chia cho 0")
               } else {
                   val result = soADouble / soBDouble
                   binding.edtResult.setText(result.toString())
               }

           }

           //Sự kiện nhấn lâu => ấn giữ
           binding.btnLongClick.setOnLongClickListener {
               if (it == binding.btnLongClick) {
                   Toast.makeText(this, "Long Clikck detected", Toast.LENGTH_SHORT).show()
                   binding.btnLongClick.visibility = View.GONE //Ẩn button sau khi xong sự kiện
               }

               true
           }
           //Thoát button
           binding.btnThoat.setOnClickListener {
               Toast.makeText(this,
                   "Tôi đi đây\nHẹn ngày tái ngộ",
                   Toast.LENGTH_SHORT).show()
               finish() //thoát ứng dụng
           }
       }catch (e: Exception){
       }
    }
}