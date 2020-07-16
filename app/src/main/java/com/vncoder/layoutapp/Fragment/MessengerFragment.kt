package com.vncoder.layoutapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.layoutapp.Adapter.MessengerAdapter
import com.vncoder.layoutapp.MainActivity3
import com.vncoder.layoutapp.Model.MessengerObject

import com.vncoder.layoutapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar_home.*
import kotlinx.android.synthetic.main.toolbar_home.toolbar


class MessengerFragment(data: MessengerObject?) : Fragment()  {


    private val MessengerObject : MessengerObject?= data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_messenger,container,false)


        if (toolbar != null) {
            (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
            (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)
        }
        var recyclerView: RecyclerView = root.findViewById(R.id.rv_messenger)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        Toast.makeText(context,MessengerObject?.name.toString(),Toast.LENGTH_SHORT).show()
        var listData : ArrayList<MessengerObject> = ArrayList()

        var  check : Int = -1
        if (this.MessengerObject != null) {

            listData.forEachIndexed { index, value ->
                if (value.name == MessengerObject!!.name) {
                    check=index
                }
            }
            listData.add(MessengerObject)
        }

        val messengerAdapter = this.context?.let { MessengerAdapter(it,listData) }
        recyclerView.adapter = messengerAdapter
        messengerAdapter?.notifyDataSetChanged()


            var adapterMess: MessengerAdapter = MessengerAdapter(root.context,listData)
            Log.d("aaa",listData.size.toString())
            recyclerView.adapter = adapterMess
            adapterMess.notifyDataSetChanged()

//        if(check!= -1 ){
//            listData.removeAt(check)
//            adapterMess.notifyItemRemoved(check)
//
//        }

        return root
    }



}