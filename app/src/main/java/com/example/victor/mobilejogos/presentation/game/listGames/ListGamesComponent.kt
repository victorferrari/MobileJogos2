package com.example.victor.mobilejogos.presentation.game.listGames

import com.example.victor.mobilejogos.data.PerScene
import com.example.victor.mobilejogos.presentation.common.FlowComponent
import dagger.Component

@PerScene
@Component(dependencies = [(FlowComponent::class)],modules = [(ListGamesModule::class)])
interface ListGamesComponent{
    fun inject(listGamesFragment: ListGamesFragment)
}