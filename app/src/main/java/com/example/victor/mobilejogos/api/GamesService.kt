package com.example.victor.mobilejogos.api

import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.game.ListGames
import retrofit2.http.GET
import rx.Observable

interface GamesService {
    @GET("s/1b7jlwii7jfvuh0/games")
    fun getGames(): Observable<ListGames>
}