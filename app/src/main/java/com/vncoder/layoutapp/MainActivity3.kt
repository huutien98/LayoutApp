package com.vncoder.layoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vncoder.layoutapp.Fragment.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private val SELECT_FRAGMENT = "SELECT_FRAGMENT"
    private val MESSENGER_FRAGMENT = "MESSENGER_FRAGMENT"
    private val NOTIFICATION_FRAGMENT = "NOTIFICATION_FRAGMENT"
    private val PROFILE_FRAGMENT = "PROFILE_FRAGMENT"

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
    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
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
                    selectedFragment = MessengerFragment()
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
}