package com.vncoder.layoutapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vncoder.layoutapp.Adapter.HomeAdapter
import com.vncoder.layoutapp.Model.HomeObject
import com.vncoder.layoutapp.R


class HomeFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home,container,false)
        var recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

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
                "Martin Palmer",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….",
                "Today, 03:24 PM",
                340)
        )
        val adapter = HomeAdapter(home)
        recyclerView.adapter = adapter




        return root
    }






}