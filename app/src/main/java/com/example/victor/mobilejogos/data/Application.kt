package com.example.victor.mobilejogos.data

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    @ApplicationContext
    fun context(): Context
}

@Module
class ApplicationModule(private val context: Context) {
    @Provides
    @Singleton
    @ApplicationContext
    fun context() = context
}