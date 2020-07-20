package com.vncoder.layoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vncoder.fragment_demo.PassData.ComunicatorInterface
import com.vncoder.layoutapp.Fragment.*
import com.vncoder.layoutapp.Model.MessengerObject
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(),ComunicatorInterface   {

    private val HOME_FRAGMENT = "HOME_FRAGMENT"
    private val SELECT_FRAGMENT = "SELECT_FRAGMENT"
    private val MESSENGER_FRAGMENT = "MESSENGER_FRAGMENT"
    private val NOTIFICATION_FRAGMENT = "NOTIFICATION_FRAGMENT"
    private val PROFILE_FRAGMENT = "PROFILE_FRAGMENT"
    private val ListClickHome : ArrayList<MessengerObject> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        bottom_navigation.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                HomeFragment()
            ).commit()
        }
        bottom_navigation.itemIconTintList = null
        fab.setOnClickListener {
            val fragment = AddFragment()
            val transaction =
                supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }



    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null
            val fragmentTransaction =
                supportFragmentManager.beginTransaction()
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    selectedFragment = HomeFragment()
                    fragmentTransaction.add(
                        R.id.fragment_container,
                        selectedFragment!!,
                        this.SELECT_FRAGMENT
                    )
                }
                R.id.nav_messenger -> {
                    selectedFragment = MessengerFragment(ListClickHome)
                    fragmentTransaction.add(
                        R.id.fragment_container,
                        selectedFragment!!,
                        this.MESSENGER_FRAGMENT
                    )
                }
                R.id.nav_add -> {
                }
                R.id.nav_notification -> {
                    selectedFragment = NotificationFragment()
                    fragmentTransaction.add(
                        R.id.fragment_container,
                        selectedFragment!!,
                        this.NOTIFICATION_FRAGMENT
                    )
                }
                R.id.nav_profile -> {
                    selectedFragment = ProfileFragment()
                    fragmentTransaction.add(
                        R.id.fragment_container,
                        selectedFragment!!,
                        this.NOTIFICATION_FRAGMENT
                    )
                }
            }
            fragmentTransaction.commit()
            true
        }

    override fun passData(data: MessengerObject) {

    }
    fun processDataFromChild(data: MessengerObject) {
        bottom_navigation.setSelectedItemId(R.id.nav_messenger)



//        var  check : Int = -1
//            ListClickHome.forEachIndexed { index, value ->
//                if (value.name == data.name) {
//                    check=index
//                }
//            }
        ListClickHome.add(data)
//        if(check!= -1 ){
//            ListClickHome.removeAt(check)
//        }


        Collections.swap(ListClickHome,ListClickHome.lastIndexOf(data),0)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = MessengerFragment(ListClickHome)

        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
        }




}