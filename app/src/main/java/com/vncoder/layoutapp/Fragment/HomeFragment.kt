package com.vncoder.layoutapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.fragment_demo.PassData.Comunicator_interface
import com.vncoder.layoutapp.Adapter.HomeAdapter
import com.vncoder.layoutapp.MainActivity3
import com.vncoder.layoutapp.Model.HomeObject
import com.vncoder.layoutapp.Model.MessengerObject
import com.vncoder.layoutapp.R
import kotlinx.android.synthetic.main.toolbar_home.*


class HomeFragment : Fragment(),Comunicator_interface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home,container,false)

        var spinner: Spinner = root.findViewById(R.id.spinner_nav) as Spinner
        var list: ArrayList<String> = ArrayList()
        list.add("All Categories")
        list.add("Sport")

        val adapterSpinner = ArrayAdapter(root.context,R.layout.support_simple_spinner_dropdown_item, list)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spinner.setAdapter(adapterSpinner)

        var recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        if (toolbar != null) {
            (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
            (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        val home = ArrayList<HomeObject>()
        home.add(
            HomeObject(
                1,
                R.drawable.profile1,
                R.drawable.background,
                "Martin Palmer",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….",
                "Today, 03:24 PM",
                340)
        )
        home.add(
            HomeObject(
                1,
                R.drawable.profile1,
                R.drawable.background,
                "michel scofile",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….",
                "Today, 05:50 PM",
                340)
        )
        home.add(
            HomeObject(
                1,
                R.drawable.profile1,
                R.drawable.background,
                "Rank con láo toét",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….",
                "Today, 08:50 PM",
                340)
        )
        home.add(
            HomeObject(
                1,
                R.drawable.profile1,
                R.drawable.background,
                "mostar lab lifetime",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….",
                "Today, 01:24 PM",
                340)
        )
        val homeAdapter = this.context?.let { HomeAdapter(it,home,this) }
        recyclerView.adapter = homeAdapter

        return root
    }



    override fun passData(data: MessengerObject) {

        val activity = activity
        if(activity is MainActivity3) {
            activity.processDataFromChild(data)
        }
        Toast.makeText(context,data.time,Toast.LENGTH_SHORT).show()
    }






}