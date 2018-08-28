package com.example.victor.mobilejogos.api

import com.example.victor.mobilejogos.presentation.game.Game
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class GamesAPI {

private val retrofit = Retrofit.Builder()
        .baseUrl("https://dl.dropboxusercontent.com/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun loadGames(): Observable<Game>{
        val service: GamesService = retrofit.create(GamesService::class.java)
        return service.getGames()
                .flatMap { gameResults -> Observable.from(gameResults.games) }
    }
}
