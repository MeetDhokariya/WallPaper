package com.example.wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class WallpaperAdapter(val mainActivity: MainActivity,val hits:List<HitsItem?>?):RecyclerView.Adapter<WallpaperAdapter.ViewDataHolder>() {

    class ViewDataHolder(itemView: View): ViewHolder(itemView)
    {
        var imgwallItem = itemView.findViewById<ImageView>(R.id.wallItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperAdapter.ViewDataHolder {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.wall_item,parent,false)
        return ViewDataHolder(view)
    }

    override fun onBindViewHolder(holder: WallpaperAdapter.ViewDataHolder, position: Int) {
        Glide.with(mainActivity).load(hits!![position]!!.webformatURL).placeholder(R.drawable.ic_launcher_background).into(holder.imgwallItem)
    }

    override fun getItemCount(): Int {
        return hits!!.size
    }
}