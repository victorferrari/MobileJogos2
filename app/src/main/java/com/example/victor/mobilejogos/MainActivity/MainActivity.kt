package com.example.victor.mobilejogos.MainActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.victor.mobilejogos.R
import com.example.victor.mobilejogos.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import ru.terrakok.cicerone.commands.SystemMessage

class MainActivity : AppCompatActivity(){

    private val listGame1: ListGames1TabFragment by lazy { ListGames1TabFragment().apply { addFragment(this) } }
    private val listGame2: ListGames2TabFragment by lazy { ListGames2TabFragment().apply { addFragment(this) } }

    private val FRAGMENT_TAGS = arrayOf(ListGames1TabFragment.className, ListGames2TabFragment.className)

    private val localCicerone = Cicerone.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationBar()

        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = navigationLista1
        }
    }

    private fun setupNavigationBar() {
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationLista1 -> localCicerone.router.replaceScreen(ListGames1TabFragment.className)
                R.id.navigationLista2 -> localCicerone.router.replaceScreen(ListGames2TabFragment.className)
            }
            true
        }
    }

    private fun addFragment(fragment: ContainerFragment) {
        supportFragmentManager.beginTransaction()
                .add(R.id.flowContainer, fragment, fragment.javaClass.simpleName)
                .detach(fragment)
                .commitNow()
    }

    private val navigator = object : Navigator {
        override fun applyCommands(commands: Array<Command>) {
            for (command in commands) applyCommand(command)
        }

        private fun applyCommand(command: Command) {
            when (command) {
                is Back -> finish()
                is SystemMessage -> Toast.makeText(this@MainActivity, command.message, Toast.LENGTH_SHORT).show()
                is Replace -> {
                    when (command.screenKey) {
                        ListGames1TabFragment.className -> changeTab(listGame1)
                        ListGames2TabFragment.className -> changeTab(listGame2)
                    }
                }
            }
        }

        private fun changeTab(targetFragment: ContainerFragment) {
            val framentTransaction = supportFragmentManager.beginTransaction()

            FRAGMENT_TAGS.forEach {
                val fragment = supportFragmentManager.findFragmentByTag(it)
                if (fragment != null && !fragment.isDetached && fragment != targetFragment) {
                    framentTransaction.detach(fragment)
                }
            }
            framentTransaction.attach(targetFragment).commitNow()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        localCicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        localCicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if (fragment != null && fragment is BackButtonListener && fragment.onBackPressed()) {
            return
        } else {
            finish()
        }
    }
}
