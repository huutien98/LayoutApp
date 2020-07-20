package com.vncoder.layoutapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.layoutapp.Adapter.MessengerAdapter
import com.vncoder.layoutapp.Model.MessengerObject

import com.vncoder.layoutapp.R
import kotlinx.android.synthetic.main.toolbar_home.toolbar


class MessengerFragment(List: ArrayList<MessengerObject>) : Fragment()  {

    private val Lists : ArrayList<MessengerObject> = List

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
//        var listData : ArrayList<MessengerObject> = ArrayList()
        val messengerAdapter = this.context?.let { MessengerAdapter(it,Lists) }
        recyclerView.adapter = messengerAdapter
        messengerAdapter?.notifyDataSetChanged()
            var adapterMess: MessengerAdapter = MessengerAdapter(root.context,Lists)
            Log.d("aaa",Lists.size.toString())
            recyclerView.adapter = adapterMess
            adapterMess.notifyDataSetChanged()

        return root
    }



}