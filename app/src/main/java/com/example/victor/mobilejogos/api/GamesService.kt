package com.example.victor.mobilejogos.api

import com.example.victor.mobilejogos.presentation.game.ListGames
import retrofit2.Call
import retrofit2.http.GET

interface GamesService {
    @GET("s/1b7jlwii7jfvuh0/games")
    fun getGames(): Call<ListGames>
}