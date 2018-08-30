package com.example.victor.mobilejogos.presentation.common

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.victor.mobilejogos.data.PerFlow
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class FlowModule(val fragmentActivity: FragmentActivity, val fm: FragmentManager, val containerId: Int){

    @Provides
    @PerFlow
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @PerFlow
    fun provideNavigator(): FlowNavigator = FlowNavigator(fragmentActivity, fm, containerId)

    @Provides
    @PerFlow
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}