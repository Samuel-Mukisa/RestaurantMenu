package com.mukisasamuel.restaurantmenu

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var listOfFoods = ArrayList<Foods>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Load foods
        listOfFoods.add(
            Foods(
                "Chicken", "Chicken is prepared with salt,onoins," +
                        "deep flied", R.drawable.chicken
            )
        )
        listOfFoods.add(
            Foods(
                "frenchfries",
                "frenchfries is prepared with salt,onoins,deep flied",
                R.drawable.french_fries
            )
        )
        listOfFoods.add(
            Foods(
                "espresso",
                "Chicken is prepared with salt,onoins,deep flied",
                R.drawable.espresso
            )
        )
        listOfFoods.add(Foods("honey", "Honey is added to tea", R.drawable.honey))
        listOfFoods.add(
            Foods(
                "Coffee",
                "Coffee is taken early in the morning",
                R.drawable.coffee_pot
            )
        )
        listOfFoods.add(
            Foods(
                "Rolex",
                "Rolex is prepared with salt,onoins,deep flied",
                R.drawable.rollex
            )
        )
        listOfFoods.add(
            Foods(
                "Strawberry",
                "Strawberry is prepared with salt,onoins,ice cream",
                R.drawable.strawberry_ice_cream
            )
        )
        adapter = FoodAdapter(this, listOfFoods)
        //Assign our list to the gridview id
        findViewById<GridView>(R.id.gvfoodlist).adapter = adapter
    }
}
     class FoodAdapter:BaseAdapter{
         var listOfFoods = ArrayList<Foods>()
         var context: Context? = null
         constructor(context: Context,listOfFoods:ArrayList<Foods>):super(){
             this.context = context
             this.listOfFoods = listOfFoods
         }

         override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
             val food = this.listOfFoods[p0]
             var inflator = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
             var foodView= inflator.inflate(R.layout.foodticket,null)
             foodView.findViewById<ImageView>(R.id.ivFoodImage).setImageResource(food.image!!)
             foodView.findViewById<ImageView>(R.id.ivFoodImage).setOnClickListener {

                 val intent = Intent(context,FoodDetails::class.java)
                 intent.putExtra("name",food.name!!)
                 intent.putExtra("des",food.des!!)
                 intent.putExtra("image",food.image!!)
                 context!!.startActivity(intent)
             }
             foodView.findViewById<TextView>(R.id.tvName).text =  food.name!!
             return  foodView

         }

         override fun getItem(p0: Int): Any {
             return listOfFoods[p0]
         }

         override fun getItemId(p0: Int): Long {
             return p0.toLong()
         }

         override fun getCount(): Int {

             return listOfFoods.size
         }
         }


