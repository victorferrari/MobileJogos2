package com.example.victor.mobilejogos.MainActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.victor.mobilejogos.Game.GameDetails.GameDetailsFragment
import com.example.victor.mobilejogos.Game.listGames.ListGamesFragment

class PagerAdapter internal constructor(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val numberOfTabs = 2

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = ListGamesFragment()
            1 -> fragment = GameDetailsFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return numberOfTabs
    }
}