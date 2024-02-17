package com.example.customlistview
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>?) :
    ArrayAdapter<ListData?>(context, R.layout.list_item, dataArrayList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        //!! bỏ qua ngoaị lệ kiểm tra null
        val image = view!!.findViewById<ImageView>(R.id.listImage)
        val name = view.findViewById<TextView>(R.id.listName)
        val time = view.findViewById<TextView>(R.id.listTime)
        image.setImageResource(listData!!.image)
        name.text = listData.name
        time.text = listData.time
        return view
    }
}