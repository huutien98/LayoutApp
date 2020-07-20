package com.vncoder.layoutapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.fragment_demo.PassData.ComunicatorInterface
import com.vncoder.layoutapp.Fragment.HomeFragment
import com.vncoder.layoutapp.Model.HomeObject
import com.vncoder.layoutapp.Model.MessengerObject
import com.vncoder.layoutapp.R
import java.text.DecimalFormat

class HomeAdapter() :RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    lateinit var  context: Context
    lateinit var ListHome: ArrayList<HomeObject>
    lateinit var comunicatorInterface: ComunicatorInterface
    var mListener: HomeFragment.IListener? = null

    constructor(context: Context, ListHome: ArrayList<HomeObject>?,comunicatorInterface: ComunicatorInterface) : this() {
        this.context = context
        this.ListHome = ListHome!!
        this.comunicatorInterface = comunicatorInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val homeView: View = layoutInflater.inflate(R.layout.item_home, parent, false)
        var viewHoder: ViewHolder= ViewHolder(homeView)
        return viewHoder
    }

    override fun getItemCount():Int {
        return ListHome.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemHome = ListHome?.get(position)
        holder.tv_name.setText(ItemHome?.name)
        holder.tv_time.setText(ItemHome?.time)
        holder.tv_status.setText(ItemHome?.status)
        val format = DecimalFormat("##,##0.00")
        holder.tv_money.text = String.format("$%s", format.format(ItemHome?.pay))
        holder.img_avatar.setImageResource(ItemHome!!.avatar)
        holder.img_status.setImageResource(ItemHome.image)

        holder.btn_heart.setOnCheckedChangeListener { buttonView, isChecked ->
            val scaleAnimation = ScaleAnimation(
                0.7f, 1.0f, 0.7f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f
            )
            scaleAnimation.duration = 500
            val bounceInterpolator = BounceInterpolator()
            scaleAnimation.interpolator = bounceInterpolator
            holder.btn_heart.startAnimation(scaleAnimation)
            mListener?.heartClickListener(isChecked, ItemHome.id)
        }

        holder.btn_more.setOnClickListener {
            val popupMenu = PopupMenu(context,holder.btn_more)
            popupMenu.inflate(R.menu.menu_popup)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item1 -> Toast.makeText(context, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.item2 -> Toast.makeText(context, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.item3 -> {
                    }
                    R.id.subitem1 -> Toast.makeText(context, "delete false", Toast.LENGTH_LONG)
                        .show()
                    R.id.subitem2 -> Toast.makeText(context, "delete false", Toast.LENGTH_LONG)
                        .show()
                }
                false
            }
            popupMenu.show()
        }

        holder.img_avatar.setOnClickListener {
            var MessengerObject  = MessengerObject(
                ItemHome.id,
                ItemHome.name,
                ItemHome.status,
                ItemHome.time,
                ItemHome.pay,
                ItemHome.avatar
            )
            comunicatorInterface.passData(MessengerObject)
        }

//        setFadeAnimation(holder.itemView) // thêm vào adapter
    }

//    fun setFadeAnimation(view: View) {
//        val anim = AlphaAnimation(0.0f, 1.0f)
//        anim.duration = 1200
//        anim.backgroundColor = Animation.ABSOLUTE
//        anim.willChangeTransformationMatrix()
//        view.startAnimation(anim)
//    }
// animation làm mờ khi cuộn recycleView


    class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        val tv_name = itemView.findViewById(R.id.tv_name_home) as TextView
        val tv_time  = itemView.findViewById(R.id.tv_time_home) as TextView
        val tv_status  = itemView.findViewById(R.id.tv_status_home) as TextView
        val tv_money   = itemView.findViewById(R.id.tv_money_home) as TextView
        val img_status   = itemView.findViewById(R.id.img_status_home) as ImageView
        val img_avatar   = itemView.findViewById(R.id.img_avatar_home) as ImageView
        val btn_heart   = itemView.findViewById(R.id.btn_heart_home) as ToggleButton
        val ic_cmt  = itemView.findViewById(R.id.ic_cmt_home) as ImageButton
        val btn_more   = itemView.findViewById(R.id.btn_more_home) as ImageButton
    }




}