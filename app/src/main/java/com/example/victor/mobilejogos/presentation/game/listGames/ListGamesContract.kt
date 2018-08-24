package com.example.victor.mobilejogos.presentation.game.listGames

import com.example.victor.mobilejogos.presentation.game.Game
import com.example.victor.mobilejogos.presentation.game.ListGames

interface ListGamesContract {
        fun displayListGames(game : Game)
        fun setMessage()
}