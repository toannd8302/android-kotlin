package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlistview.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val time = intent.getStringExtra("time")
            val ingredients = intent.getIntExtra("ingredients", R.string.maggiIngredients)
            val desc = intent.getIntExtra("desc", R.string.maggieDesc)
            val image = intent.getIntExtra("image", R.drawable.maggi_300x169)
            binding.detailedName.text = name
            binding.detailedTime.text = time
            binding.detailedIngredients.setText(ingredients)
            binding.detailSteps.setText(desc)
            binding.detailedImage.setImageResource(image)
        }
    }
}