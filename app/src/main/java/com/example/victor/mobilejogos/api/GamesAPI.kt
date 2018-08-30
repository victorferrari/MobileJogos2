package com.example.victor.mobilejogos.api

import com.example.victor.mobilejogos.presentation.game.ListGames
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GamesAPI {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service = retrofit.create(GamesService::class.java)

    fun loadGames(): Observable<ListGames> {
        return service.getGames()
    }
}
