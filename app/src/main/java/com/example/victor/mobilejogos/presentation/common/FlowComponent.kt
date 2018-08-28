package com.example.victor.mobilejogos.presentation.common

import com.example.victor.mobilejogos.data.ApplicationComponent
import com.example.victor.mobilejogos.data.PerFlow
import dagger.Component
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@PerFlow
@Component(dependencies = [(ApplicationComponent::class)], modules = [(FlowModule::class)])
interface FlowComponent : ApplicationComponent {
    fun inject(containerFragment: ContainerFragment)
    fun provideCicerone(): Cicerone<Router>
    fun provideRouter(): Router
}