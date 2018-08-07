package com.example.victor.mobilejogos.MainActivity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.victor.mobilejogos.Game.GameDetails.GameDetailsFragment
import com.example.victor.mobilejogos.Game.listGames.ListGamesFragment
import com.example.victor.mobilejogos.R

class MainActivity : AppCompatActivity(), ListGamesFragment.OnFragmentInteractionListener, GameDetailsFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
