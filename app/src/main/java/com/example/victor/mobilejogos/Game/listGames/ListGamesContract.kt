package com.example.victor.mobilejogos.Game.listGames

import com.example.victor.mobilejogos.Game.Game

interface ListGamesContract {
    interface View {
        fun displayListGames(listGames : List<Game>)
        fun setMessage()
    }
}