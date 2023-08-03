package com.example.fragment_test_001

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerAdapter(tourList: ArrayList<Int>,
    private val viewPager2: ViewPager2) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    private var item = tourList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.tour.setImageResource(item[position])
        if(position == item.size -1) {
            viewPager2.post(runnable)
        }
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.slide_item_container, parent, false)){
            val tour = itemView.findViewById<ImageView>(R.id.slideImageview)!!
    }
    private val runnable = Runnable {tourList.addAll(tourList)}
}