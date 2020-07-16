package com.vncoder.layoutapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.layoutapp.Model.MessengerObject
import com.vncoder.layoutapp.R

class MessengerAdapter(val context: Context, val ListMessenger:ArrayList<MessengerObject>?)
    : RecyclerView.Adapter<MessengerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_messenger,parent,false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount() = ListMessenger!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemMessenger = ListMessenger?.get(position)
        holder.img_avatar_messenger.setImageResource(ItemMessenger?.avatar!!)
        holder.tv_messenger_messenger.setText(ItemMessenger.messenger)
        holder.tv_name_messenger.setText(ItemMessenger.name)
        holder.tv_number_messenger.setText(ItemMessenger.number.toString())
        holder.tv_time_messenger.setText(ItemMessenger.time)


    }


    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val img_avatar_messenger = itemView.findViewById<ImageView>(R.id.img_avatar_messenger)
        val tv_name_messenger = itemView.findViewById<TextView>(R.id.tv_name_messenger)
        val tv_messenger_messenger = itemView.findViewById<TextView>(R.id.tv_messenger_messenger)
        val tv_number_messenger = itemView.findViewById<TextView>(R.id.tv_number_messenger)
        val tv_time_messenger = itemView.findViewById<TextView>(R.id.tv_time_messenger)




    }
}