package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter(private val items: List<Item>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameView: TextView
        var priceView: TextView
        var descriptionView: TextView

        init {
            nameView = itemView.findViewById(R.id.name)
            priceView = itemView.findViewById(R.id.price)
            descriptionView = itemView.findViewById(R.id.description)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val wishListItemView = inflater.inflate(R.layout.list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(wishListItemView)
    }

    override fun onBindViewHolder(holder: WishListAdapter.ViewHolder, position: Int) {
        val item = items.get(position)
        // Set item views based on views and data model
        holder.nameView.text = item.name
        holder.priceView.text = item.price.toString()
        holder.descriptionView.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}