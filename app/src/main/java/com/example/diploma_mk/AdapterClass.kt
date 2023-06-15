package com.example.diploma_mk

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diploma_mk.DATA.DataClass
import com.example.diploma_mk.Topic.AndroidTopic
import com.example.diploma_mk.Topic.DesignTopic
import com.example.diploma_mk.Topic.KotlinTopic

class AdapterClass(private val dataList: ArrayList<DataClass>,
                   private val typeFragment: Int): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle


        holder.itemView.setOnClickListener {
            when(typeFragment) {
                1 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, KotlinTopic::class.java)
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 1){
                        var a = Intent(holder.itemView.context, KotlinTopic::class.java)
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 2){
                        var a = Intent(holder.itemView.context, KotlinTopic::class.java)
                        baf = 3
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 3){
                        var a = Intent(holder.itemView.context, KotlinTopic::class.java)
                        baf = 4
                        holder.itemView.context.startActivity(a)
                    }
                }
                2 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, AndroidTopic::class.java)
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 1){
                        var a = Intent(holder.itemView.context, AndroidTopic::class.java)
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 2){
                        var a = Intent(holder.itemView.context, AndroidTopic::class.java)
                        baf = 3
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 3){
                        var a = Intent(holder.itemView.context, AndroidTopic::class.java)
                        baf = 4
                        holder.itemView.context.startActivity(a)
                    }

                }

                3 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, DesignTopic::class.java)
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }
                   if(position == 1){
                        var a = Intent(holder.itemView.context, DesignTopic::class.java)
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 2){
                        var a = Intent(holder.itemView.context, DesignTopic::class.java)
                        baf = 3
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 3){
                        var a = Intent(holder.itemView.context, DesignTopic::class.java)
                        baf = 4
                        holder.itemView.context.startActivity(a)
                    }
                }
                4 -> {
                    if(position == 0){
                        var a = Intent(holder.itemView.context, PlayActivity::class.java)
                        a.flags = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                            //baf нужен для определения какой будет тест
                        baf = 1
                        holder.itemView.context.startActivity(a)
                    }
                    if(position == 1){
                        var a = Intent(holder.itemView.context, PlayActivity::class.java)
                        a.flags = Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                        baf = 2
                        holder.itemView.context.startActivity(a)
                    }

                }

            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }



    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {

        val rvImage: ImageView = itemView.findViewById(R.id.image)
        val rvTitle: TextView = itemView.findViewById(R.id.title)

    }

}