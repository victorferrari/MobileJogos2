package com.example.victor.mobilejogos.MainActivity


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.victor.mobilejogos.Game.listGames.ListGamesFragment
import com.example.victor.mobilejogos.R
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

sealed class ContainerFragment : Fragment(), BackButtonListener {

    var cicerone: Cicerone<Router> = Cicerone.create()
    lateinit var navigator: FlowNavigator

    companion object {
        val className: String = ContainerFragment::class.java.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = FlowNavigator(activity as FragmentActivity, childFragmentManager, R.id.fragmentContainer)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(R.id.fragmentContainer) == null)
            cicerone.router.replaceScreen(ListGamesFragment.className)
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        val childFragment = childFragmentManager.findFragmentById(R.id.fragmentContainer)
        return childFragment != null && childFragment is BackButtonListener && childFragment.onBackPressed()
    }
}

class ListGames1TabFragment : ContainerFragment() {
    companion object {
        val className: String = ListGames1TabFragment::class.java.simpleName
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(R.id.fragmentContainer) == null)
            cicerone.router.replaceScreen(ListGamesFragment.className)
    }
}

class ListGames2TabFragment : ContainerFragment() {
    companion object {
        val className: String = ListGames1TabFragment::class.java.simpleName
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(R.id.fragmentContainer) == null)
            cicerone.router.replaceScreen(ListGamesFragment.className)
    }
}
