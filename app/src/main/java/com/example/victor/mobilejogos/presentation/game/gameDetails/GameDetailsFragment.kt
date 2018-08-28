package com.example.victor.mobilejogos.presentation.game.gameDetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.victor.mobilejogos.presentation.common.BackButtonListener
import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.common.ContainerFragment
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.fragment_game_details.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class GameDetailsFragment : Fragment(), BackButtonListener {

    lateinit var game : Game

    @Inject
    lateinit var router: Router

    companion object {
        fun newInstance(args: Game) : GameDetailsFragment = GameDetailsFragment().apply {
            game = args
        }
        val className : String = GameDetailsFragment::class.java.simpleName
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

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
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
