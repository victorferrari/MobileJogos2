package com.example.victor.mobilejogos.Game.listGames

import com.example.victor.mobilejogos.Game.ListGames
import com.example.victor.mobilejogos.api.GamesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.terrakok.cicerone.Router

class ListGamesPresenter(private val view: ListGamesContract.View) {

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
