package com.example.victor.mobilejogos.Game.listGames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.activity_list_games.*
import com.example.victor.mobilejogos.Game.GameDetails.GamesDetailsActivity
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import java.io.Serializable

class ListGamesActivity : AppCompatActivity(), ListGamesContract.View, OnItemClickListener {

    lateinit var presenter: ListGamesPresenter
    lateinit var adapter: ListGamesAdapter

    override fun onClick(game: Game) {
        val intent = Intent(this, GamesDetailsActivity::class.java)
        intent.putExtra(GamesDetailsActivity.gameExtra, game as Serializable)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_games)

        adapter = ListGamesAdapter(this)
        rvGames.layoutManager = LinearLayoutManager(this)
        rvGames.adapter = adapter
        presenter = ListGamesPresenter(this)
        presenter.getListGames()

        title = "Lista de Games"
    }

    override fun displayListGames(listGames: List<Game>) {
        progressbar.visibility = View.GONE
        adapter.setData(listGames)
        adapter.setOnItemClickListener(this)
        rvGames.adapter = adapter
    }

    override fun setMessage() {
        Toast.makeText(applicationContext, "Falha no acesso ao servidor", Toast.LENGTH_SHORT).show()
        progressbar.visibility = View.GONE
    }
}
