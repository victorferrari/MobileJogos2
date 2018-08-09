package com.example.victor.mobilejogos.MainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewAdapter = PagerAdapter(supportFragmentManager)
        viewPager.adapter = viewAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
