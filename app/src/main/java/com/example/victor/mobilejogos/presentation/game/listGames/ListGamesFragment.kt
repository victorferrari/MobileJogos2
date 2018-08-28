package com.example.victor.mobilejogos.presentation.game.listGames

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.victor.mobilejogos.presentation.common.BackButtonListener
import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.game.gameDetails.GameDetailsFragment
import com.example.victor.mobilejogos.presentation.game.ListGames
import com.example.victor.mobilejogos.presentation.common.ContainerFragment
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.fragment_list_games.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ListGamesFragment : Fragment(), ListGamesContract, OnItemClickListener, BackButtonListener{

    @Inject
    lateinit var presenter: ListGamesPresenter

    lateinit var adapter: ListGamesAdapter
    lateinit var router: Router
    var container: ViewGroup? = null

    companion object {
        val className : String = ListGamesFragment::class.java.simpleName
    }

    val component: ListGamesComponent? by lazy {
        context?.let {
            DaggerListGamesComponent.builder()
                    .flowComponent((parentFragment as ContainerFragment).component)
                    .listGamesModule(ListGamesModule(this))
                    .build()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component?.inject(this)
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
        clearAdapter()
        recyclerGames.adapter = adapter
        recyclerGames.layoutManager = LinearLayoutManager(context)
        adapter.setOnItemClickListener(this)

        presenter.getListGames()
    }

    override fun onClick(game: Game) {
        router.navigateTo(GameDetailsFragment.className, game)
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun displayListGames(game: Game) {
        adapter.setData(game)
    }

    override fun setMessage() {
        Toast.makeText(context, "Falha no acesso ao servidor", Toast.LENGTH_SHORT).show()
    }

    fun clearAdapter() {
        adapter.clear()
        adapter.notifyDataSetChanged()
    }
}
