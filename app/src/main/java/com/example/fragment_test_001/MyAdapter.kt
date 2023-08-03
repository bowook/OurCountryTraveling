package com.example.fragment_test_001

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val areaList : ArrayList<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
//Model 데이터에 있는 정보를 areaList에 연결

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row,
        parent, false)
        return MyViewHolder(itemView)
    }

    interface ItemClick
    {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //활용
        val currentItem = areaList[position]
        holder.areaImage.setImageResource(currentItem.image)
        holder.areaTitle.text = currentItem.title
        holder.areaDes.text = currentItem.des

        if(itemClick != null) {
            holder.itemView.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
    }
    override fun getItemCount(): Int {
        return areaList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        //아이템을 모아놓은거고 모아놓았으니까
        val areaImage: ImageView = itemView.findViewById(R.id.imageIv)
        val areaTitle: TextView = itemView.findViewById(R.id.titleIv)
        val areaDes: TextView = itemView.findViewById(R.id.descriptionIv)
    }
}
