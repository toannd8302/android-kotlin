package com.example.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.customlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameList = arrayOf("pasta", "Maggi", "Cake", "PanCake", "Pizza", "Burgers", "Fries")
        val timeList = arrayOf("30 min", "10 min", "1 hour", "30 min", "1 hour", "30 min", "20 min")
        val imageList = intArrayOf(
            R.drawable.pasta_300x169,
            R.drawable.maggi_300x169,
            R.drawable.cake_300x169,
            R.drawable.pancake_300x169,
            R.drawable.pizza_300x169,
            R.drawable.burger_300x169,
            R.drawable.fries_300x169
        )
        val ingredientsList = intArrayOf(
            R.string.pastaIngredients,
            R.string.maggiIngredients,
            R.string.cakeIngredients,
            R.string.pancakeIngredients,
            R.string.pizzaIngredients,
            R.string.burgerIngredients,
            R.string.friesIngredients
        )
        val descList = intArrayOf(
            R.string.pastaDesc,
            R.string.maggieDesc,
            R.string.cakeDesc,
            R.string.pancakeDesc,
            R.string.pizzaDesc,
            R.string.burgerDesc,
            R.string.friesDesc
        )
        for (i in imageList.indices) {
            listData =
                ListData(nameList[i], timeList[i], ingredientsList[i], descList[i], imageList[i])
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listView.adapter = listAdapter
        binding.listView.isClickable = true
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this@MainActivity, DetailedActivity::class.java)
                intent.putExtra("name", nameList[position])
                intent.putExtra("time", timeList[position])
                intent.putExtra("ingredients", ingredientsList[position])
                intent.putExtra("desc", descList[position])
                intent.putExtra("image", imageList[position])
                startActivity(intent)
            }
    }
}