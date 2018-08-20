package com.example.victor.mobilejogos.presentation.game.listGames

import com.example.victor.mobilejogos.data.PerScene
import dagger.Module
import dagger.Provides

@Module
class ListGamesModule(private val listGamesContract: ListGamesContract) {

    @Provides
    @PerScene
    fun provideListGamesContract(): ListGamesContract {
        return listGamesContract
    }
}