package com.example.productgallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val products: ArrayList<Product>, var recyclerViewInterface: RecyclerViewInterface)
    :RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View, recyclerViewInterface: RecyclerViewInterface) : RecyclerView.ViewHolder(view) {
        var productName: TextView = view.findViewById(R.id.product_name_textView)
        var productBrand: TextView = view.findViewById(R.id.brand_textView)
        var productPrice: TextView = view.findViewById(R.id.price_textView)
        var productDiscount: TextView = view.findViewById(R.id.discount_textView)
        var image: ImageView = view.findViewById(R.id.imageView)
        init {
            view.setOnClickListener {
                if(recyclerViewInterface != null) {
                    var pos: Int = adapterPosition

                    if(pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_view, parent, false)
        return MyViewHolder(itemView, recyclerViewInterface)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(products.get(position).image)
        holder.productName.setText(products.get(position).productName)
        holder.productBrand.setText(products.get(position).productBrand)
        holder.productPrice.setText("Rs. ${products.get(position).productPrice.toString()}")
        holder.productDiscount.setText("${products.get(position).productDiscount.toString()} % Offer")
    }

    override fun getItemCount(): Int {
        return products.size
    }

}