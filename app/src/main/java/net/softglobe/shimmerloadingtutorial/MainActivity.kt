package net.softglobe.shimmerloadingtutorial

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import net.softglobe.shimmerloadingtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            binding.shimmerLayout.visibility = View.GONE
            binding.rvProducts.visibility = View.VISIBLE
        }, 3000)

        val productList = mutableListOf(
            Product(1,"Ball Pen", R.drawable.pen, 20),
            Product(2,"Writing Pad", R.drawable.pad, 25),
            Product(3,"Branded Eraser", R.drawable.eraser, 10),
            Product(4,"Premium Wallet", R.drawable.wallet, 250),
            Product(5,"School bag", R.drawable.bag, 800),
            Product(6,"Compass Box", R.drawable.compass_box, 150),
            Product(6,"Table Lamp", R.drawable.table_lamp, 350),
        )


        binding.rvProducts.apply {
            adapter = ProductsListAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity)
            (binding.rvProducts.adapter as ProductsListAdapter).submitList(productList)
        }
    }
}