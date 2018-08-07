package com.example.victor.mobilejogos.Game.ListGames

import com.example.victor.mobilejogos.Game.ListGame
import com.example.victor.mobilejogos.api.GamesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListGamesPresenter(private val view : ListGamesContract.View){
    fun getListGames(){
        val call = GamesAPI().GamesService().getGames()
        call.enqueue(object : Callback<ListGame>{
            override fun onResponse(call: Call<ListGame>, response: Response<ListGame>) {
                val listGame : ListGame? = response.body()
                view.displayListGames(listGame!!.games)
            }
            override fun onFailure(call: Call<ListGame>, t: Throwable) {
                view.setMessage()
            }
        })
    }
}
