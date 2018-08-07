package com.example.victor.mobilejogos.Game.listGames

import com.example.victor.mobilejogos.Game.ListGames
import com.example.victor.mobilejogos.api.GamesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListGamesPresenter(private val view : ListGamesContract.View){
    fun getListGames(){
        val call = GamesAPI().GamesService().getGames()
        call.enqueue(object : Callback<ListGames>{
            override fun onResponse(call: Call<ListGames>, response: Response<ListGames>) {
                val listGames : ListGames? = response.body()
                view.displayListGames(listGames!!.games)
            }
            override fun onFailure(call: Call<ListGames>, t: Throwable) {
                view.setMessage()
            }
        })
    }
}
