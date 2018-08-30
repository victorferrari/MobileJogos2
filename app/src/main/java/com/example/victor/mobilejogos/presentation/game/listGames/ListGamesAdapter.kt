package com.example.victor.mobilejogos.presentation.game.listGames

import android.content.Context
import com.bumptech.glide.Glide
import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.game.ListGames
import com.example.victor.mobilejogos.R.layout.game_item_list
import com.jakewharton.rxbinding2.view.clicks
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.game_item_list.view.*

class ListGamesAdapter(private val context: Context) : GroupAdapter<ViewHolder>() {

    private val onItemSelecetedSubject: PublishSubject<Game> = PublishSubject.create()
    val onItemSelected: Observable<Game> = onItemSelecetedSubject

    inner class GameItem(private val game: Game) : Item() {
        override fun getLayout() = game_item_list

        override fun bind(viewHolder: ViewHolder, position: Int) {
            game?.let { safeGame ->
                val game: Game = safeGame
                viewHolder.itemView.clicks().subscribe {
                    onItemSelecetedSubject.onNext(game)
                }
                Glide.with(context)
                        .load(game.image)
                        .centerCrop()
                        .into(viewHolder.itemView.gameImage)
            }
        }
    }

    fun setData(listGames: ListGames) {
        clear()
        listGames.games.forEach { game ->
            add(GameItem(game))
        }
    }
}
