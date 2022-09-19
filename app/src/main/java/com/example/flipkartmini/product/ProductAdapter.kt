package com.example.flipkartmini.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartmini.R
import com.example.flipkartmini.databinding.LayoutProductListItemBinding
import com.example.flipkartmini.datalib.models.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products: List<Product> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(
        LayoutProductListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    fun submitList(list: List<Product>) {
        products = list
    }

    inner class ProductViewHolder(private val binding: LayoutProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.product = item
            item.id?.let {
                val imageRes = when(it.toInt() % 3){
                    0 -> R.drawable.shoes1
                    1 -> R.drawable.shoes2
                    else -> R.drawable.shoes3
                }
                binding.imgProduct.setImageResource(imageRes)
            }

        }
    }
}