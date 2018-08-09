package com.example.victor.mobilejogos.Game.listGames

import com.example.victor.mobilejogos.Game.ListGames

interface ListGamesContract {
    interface View {
        fun displayListGames(listGames : ListGames)
        fun setMessage()
    }
}