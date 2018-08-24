package com.example.victor.mobilejogos.presentation.game.listGames

import com.example.victor.mobilejogos.presentation.game.ListGames
import com.example.victor.mobilejogos.api.GamesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListGamesPresenter @Inject constructor(private val view: ListGamesContract) {

    fun getListGames() {
        val call = GamesAPI().GamesService().getGames()
        call.enqueue(object : Callback<ListGames> {
            override fun onResponse(call: Call<ListGames>, response: Response<ListGames>) {
                val listGame: ListGames? = response.body()
                if (listGame != null) {
                    view.displayListGames(listGame)
                } else {
                    view.setMessage()
                }
            }

            override fun onFailure(call: Call<ListGames>, t: Throwable) {
                view.setMessage()
            }
        })
    }
}
