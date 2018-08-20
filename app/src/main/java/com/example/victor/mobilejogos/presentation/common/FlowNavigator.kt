package com.example.victor.mobilejogos.presentation.common

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.game.gameDetails.GameDetailsFragment
import com.example.victor.mobilejogos.presentation.game.listGames.ListGamesFragment
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class FlowNavigator @Inject constructor(fragmentActivity: FragmentActivity, fm: FragmentManager, containerId: Int) : SupportAppNavigator(fragmentActivity, fm, containerId) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return when (screenKey){
            ListGamesFragment.className -> return ListGamesFragment()
            GameDetailsFragment.className ->{
                if(data is Game){
                    return GameDetailsFragment.newInstance(data)
                }else{
                    throw IllegalArgumentException("Trying to open GameDetailsFragment without providing current Game")
                }
            }
            else -> null
        }
    }
}