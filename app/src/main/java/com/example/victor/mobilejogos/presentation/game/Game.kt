package com.example.victor.mobilejogos.presentation.game

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Game(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("release_date")
        val release_date: String,
        @SerializedName("trailer")
        val trailer: String,
        @SerializedName("platforms")
        val platforms: List<String>) : Serializable
