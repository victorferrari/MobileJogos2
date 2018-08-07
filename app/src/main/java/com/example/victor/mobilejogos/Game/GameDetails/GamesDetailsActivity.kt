package com.example.victor.mobilejogos.Game.GameDetails

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.activity_games_details.*

class GamesDetailsActivity : AppCompatActivity() {

    companion object {
        val gameExtra = "details"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_details)

        val intent = intent
        val game : Game = intent.getSerializableExtra(gameExtra) as Game

        Glide.with(applicationContext)
                .load(game.image)
                .centerCrop()
                .into(detailsImage)

        detailsName.text = game.name
        detailsReleaseDate.text = game.release_date
        detailsPlatforms.text = getPlatforms(game.platforms)
    }

    private fun getPlatforms(plataformas: List<String>): StringBuilder{
        lateinit var details: StringBuilder
        for (i in plataformas.indices){
            if(i == 0){
                details = StringBuilder(plataformas[i])
            } else{
                details.append(", ").append(plataformas[i])
            }
        }
        return details
    }
}
