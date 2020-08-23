package com.example.enigmanetflixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (main_navigation as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.showMovie -> {
                    navController.navigate(R.id.action_to_movieListFragment)
                    true
                }

                R.id.createMovie -> {
                    navController.navigate(R.id.action_to_createMovieFragment)
                    true
                }
                else -> {
                    println("MASUK ELSE")
                    false
                }
            }
        }

    }
}