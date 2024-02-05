package com.example.basicview
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.SuperscriptSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_ui)
        //Trang trí nội dung TextView với SpannableString
        val myTextView: TextView = findViewById(R.id.textView2)
        val noidung = """
            SpannableString
            Chữ đậm
            Gạch chân
            Nghiêng
            Kẻ ngang
            Màu sắc
            12AM
            Click Me
            URL
            
            """.trimIndent() //74 - 76


        val noidungspanned = SpannableString(noidung)

        noidungspanned.setSpan(RelativeSizeSpan(2f), 0, 15, 0)
        noidungspanned.setSpan(StyleSpan(Typeface.BOLD), 16, 23, 0)
        noidungspanned.setSpan(UnderlineSpan(), 24, 33, 0)
        noidungspanned.setSpan(StyleSpan(Typeface.ITALIC), 34, 42, 0)
        noidungspanned.setSpan(StrikethroughSpan(), 42, 50, 0)
        noidungspanned.setSpan(BackgroundColorSpan(Color.GREEN), 51, 59, 0)
        noidungspanned.setSpan(ForegroundColorSpan(Color.RED), 34, 51, 0)
        noidungspanned.setSpan(SuperscriptSpan(), 61, 64, 0)
        noidungspanned.setSpan(RelativeSizeSpan(.9f), 61, 64, 0)
        noidungspanned.setSpan(URLSpan("https://xuanthulab.net"), 64, 73, 0)

        noidungspanned.setSpan(object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(view.context, "Clicked me", Toast.LENGTH_SHORT).show()
            }
        }, 73, 76, 0)

// Gọi setMovementMethod cho phép click vào Url
        myTextView.movementMethod = LinkMovementMethod.getInstance()
        myTextView.text = noidungspanned


//        //tên biến nên đặt giống với iD khi design
//        //Khai báo biến
//        val txtSoA = findViewById<TextView>(R.id.txtSoA)
//        val edtSoA = findViewById<EditText>(R.id.edtSoA)
//        val extSoB = findViewById<EditText>(R.id.extSoB)
//        val txtSoB = findViewById<TextView>(R.id.txtSoB)
//        val edtResult = findViewById<EditText>(R.id.edtResult)
//        val btnCong = findViewById<Button>(R.id.btnCong)
//        val btnReset = findViewById<Button>(R.id.btnReset)
//        //Code event trên btnCong
//        btnCong.setOnClickListener {
//            val aInt = edtSoA.text.toString().toInt()
//            val bInt = extSoB.text.toString().toInt()
//            val result = aInt + bInt
//            edtResult.setText(result.toString())
//        }
//        //Code event trên btnReset
//        btnReset.setOnClickListener {
//            edtSoA.setText("")
//            extSoB.setText("")
//            edtResult.setText("")
//            //Thông báo nhanh trên màn hình
//            Toast.makeText(this, "Reset successfully", Toast.LENGTH_SHORT).show()
//        }

    }
}