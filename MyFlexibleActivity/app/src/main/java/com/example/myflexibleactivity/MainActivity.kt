package com.example.myflexibleactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fragmenManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmenManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){
            Log.d("My Flexible Fragment", "Fragment Name : " + HomeFragment::class.java.simpleName)
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}