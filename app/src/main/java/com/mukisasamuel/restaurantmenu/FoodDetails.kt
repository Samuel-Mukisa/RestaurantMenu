package com.mukisasamuel.restaurantmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle = intent.extras
        findViewById<ImageView>(R.id.ivFoodimage).setImageResource(bundle !!.getInt("image"))
        findViewById<TextView>(R.id.tvName).text=bundle!!.getString("name")
        findViewById<TextView>(R.id.tvDetails).text=bundle!!.getString("des")



    }
}