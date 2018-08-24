package com.example.victor.mobilejogos.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GamesAPI {

private val retrofit = Retrofit.Builder()
        .baseUrl("https://dl.dropboxusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun GamesService(): GamesService = retrofit.create(GamesService::class.java)
}
