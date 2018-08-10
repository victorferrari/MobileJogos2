package com.example.victor.mobilejogos.Game.listGames


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.victor.mobilejogos.Game.BackButtonListener
import com.example.victor.mobilejogos.MainActivity.FlowNavigator
import com.example.victor.mobilejogos.R
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class ContainerFragment : Fragment(), BackButtonListener {

    var cicerone: Cicerone<Router> = Cicerone.create()
    lateinit var navigator: FlowNavigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_container, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = FlowNavigator(activity as FragmentActivity, childFragmentManager, R.id.fragmentContainer )
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
        return if(childFragment != null && childFragment is BackButtonListener && childFragment.onBackPressed()){
            cicerone.router.exit()
            true
        }else {
            false
        }
    }
}
