package com.example.victor.mobilejogos.presentation.game.listGames

import com.example.victor.mobilejogos.api.GamesAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListGamesPresenter @Inject constructor(private val view: ListGamesContract) {

    fun getListGames() {

        val api = GamesAPI()
        api.loadGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.displayListGames(it)
                }
    }
}
