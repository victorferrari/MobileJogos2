package com.example.victor.mobilejogos.Game.GameDetails

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.fragment_game_details.*
import kotlinx.android.synthetic.main.fragment_game_details.view.*

class GameDetailsFragment : Fragment() {

    lateinit var game : Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_game_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(context)
                .load(game.image)
                .centerCrop()
                .into(detailsImageFragment)

        detailsNameFragment.text = game.name
        detailsReleaseDateFragment.text = game.release_date
        detailsPlatformsFragment.text = getPlatforms(game.platforms)
    }

    companion object {
        fun newInstance(args: Game) : GameDetailsFragment = GameDetailsFragment().apply {
            game = args
        }
    }

    private fun getPlatforms(plataformas: List<String>): StringBuilder {
        lateinit var details: StringBuilder
        for (i in plataformas.indices) {
            if (i == 0) {
                details = StringBuilder(plataformas[i])
            } else {
                details.append(", ").append(plataformas[i])
            }
        }
        return details
    }
}
