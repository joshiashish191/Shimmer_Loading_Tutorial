package net.softglobe.shimmerloadingtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.softglobe.shimmerloadingtutorial.databinding.ItemProductBinding

class ProductsListAdapter : ListAdapter<Product, ProductsListAdapter.ProductViewHolder>(ProductDiffUtils()) {
    lateinit var binding : ItemProductBinding

    inner class ProductViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            binding.productImg.setBackgroundResource(product.image)
            binding.productTitle.text = product.name
            binding.productPrice.text = "₹ ${product.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        return ProductViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductDiffUtils : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}