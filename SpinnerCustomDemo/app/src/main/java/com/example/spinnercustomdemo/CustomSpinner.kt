package com.example.spinnercustomdemo

import android.app.Activity
import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class CustomSpinner(val activity: Activity, val list2: List<OutData>):
    ArrayAdapter<OutData>(activity, R.layout.spinner_custom_view) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun getCount(): Int {
        //Tạo số dòng trên Spinner
        return list2.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Hiển thị cho người dùng lựa chọn đầu tiên trong Spinner
        /*
        * - position trả về vị trị của phần tử trong list => ở đây là list2
        * - convertView hiển thị chế độ xem cho từng mục
        * - parent: ViewGroup cha đang chứa Spinner
        * */
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Người dùng tương tác click chọn Spinner
        return initView(position, convertView, parent)
    }

    //hàm xử lí View trả về View
    //Thieu 1 trong các hàm dưới đây ứng dụng sẽ crash
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        val contests = activity.layoutInflater
        //layoutInflater là 1 component giúp chuyển layout xml => view trong android
        //Dòng lệnh chuyển đổi xml thành View
        val rowView = contests.inflate(R.layout.spinner_custom_view, parent,false)

        //Mapping giao diện
        val iamges = rowView.findViewById<ImageView>(R.id.imageFruit)
        val txtFruit = rowView.findViewById<TextView>(R.id.txtFruit)

        //gán hình ảnh và title cho tung72 dòng trên Spinner
        iamges.setImageResource(list2[position].image)
        txtFruit.text = list2[position].title
        return rowView
    }
}