package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hohoho.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)


        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navHostFragment = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.dashboardFragment,
                R.id.profileFragment,
                R.id.aboutFragment,
            )
        )
        setupActionBarWithNavController(navHostFragment, appBarConfiguration)
        bottomNavView.setupWithNavController(navHostFragment)





    }


}