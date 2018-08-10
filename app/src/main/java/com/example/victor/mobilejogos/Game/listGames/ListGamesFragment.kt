package com.example.victor.mobilejogos.Game.listGames

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.victor.mobilejogos.Game.BackButtonListener
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.Game.GameDetails.GameDetailsFragment
import com.example.victor.mobilejogos.Game.ListGames
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.fragment_list_games.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class ListGamesFragment : Fragment(), ListGamesContract.View, OnItemClickListener, BackButtonListener {

    lateinit var presenter: ListGamesPresenter
    lateinit var adapter: ListGamesAdapter
    lateinit var router: Router
    var container: ViewGroup? = null

    companion object {
        val className : String = ListGamesFragment::class.java.simpleName
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = ListGamesAdapter(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_games, container, false)

        this.container = container
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = (parentFragment as ContainerFragment).cicerone.router

        recyclerGames.adapter = adapter
        recyclerGames.layoutManager = LinearLayoutManager(context)
        adapter.setOnItemClickListener(this)
        presenter = ListGamesPresenter(this)
        presenter.getListGames()
    }

    override fun onClick(game: Game) {
        router.navigateTo(GameDetailsFragment.className, game)
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun displayListGames(listGames: ListGames) {
        progressbar.visibility = View.GONE
        adapter.setData(listGames)
    }

    override fun setMessage() {
        Toast.makeText(context, "Falha no acesso ao servidor", Toast.LENGTH_SHORT).show()
        progressbar.visibility = View.GONE
    }
}
