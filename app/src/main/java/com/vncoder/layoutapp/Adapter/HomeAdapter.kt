package com.vncoder.layoutapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.layoutapp.Model.HomeObject
import com.vncoder.layoutapp.R
import java.text.DecimalFormat

class HomeAdapter(val ListHome:ArrayList<HomeObject>? )
    :RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var ctx: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount()=ListHome!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemHome = ListHome?.get(position)
        holder.tv_name.setText(ItemHome?.name)
        holder.tv_time.setText(ItemHome?.time)
        holder.tv_status.setText(ItemHome?.status)
        val format = DecimalFormat("##,##0.00")
        holder.tv_money.text = String.format("$%s", format.format(ItemHome?.pay))
        holder.img_avatar.setImageResource(ItemHome!!.avatar)
        holder.img_status.setImageResource(ItemHome.image)

        holder.btn_more.setOnClickListener {
            val popupMenu =
                PopupMenu(ctx, holder.btn_more)
            popupMenu.inflate(R.menu.menu_popup)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item1 -> Toast.makeText(ctx, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.item2 -> Toast.makeText(ctx, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.item3 -> {
                    }
                    R.id.subitem1 -> Toast.makeText(ctx, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.subitem2 -> Toast.makeText(ctx, "delete false", Toast.LENGTH_LONG)
                        .show()
                }
                false
            }
            popupMenu.show()
        }

        setFadeAnimation(holder.itemView)

    }

    fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1200
        anim.backgroundColor = Animation.ABSOLUTE
        anim.willChangeTransformationMatrix()
        view.startAnimation(anim)
    }

    class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        val tv_name = itemView.findViewById(R.id.tv_name) as TextView
        val tv_time  = itemView.findViewById(R.id.tv_time) as TextView
        val tv_status  = itemView.findViewById(R.id.tv_status) as TextView
        val tv_money   = itemView.findViewById(R.id.tv_money) as TextView
        val img_status   = itemView.findViewById(R.id.img_status) as ImageView
        val img_avatar   = itemView.findViewById(R.id.img_avatar) as ImageView
        val btn_heart   = itemView.findViewById(R.id.btn_heart) as ToggleButton
        val ic_cmt  = itemView.findViewById(R.id.ic_cmt) as ImageButton
        val btn_more   = itemView.findViewById(R.id.btn_more) as ImageButton
    }
}