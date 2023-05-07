package com.example.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottom_navigation.fragment.HomeFragment
import com.example.bottom_navigation.fragment.NotificationFragment
import com.example.bottom_navigation.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION", "UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationsFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()
        
        makeCurrentFragment (homeFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notificationsFragment)
                R.id.menu_setting -> makeCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply { 
            replace(R.id.frame_nav,fragment)
            commit()
        }

    }
}