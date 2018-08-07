package com.example.victor.mobilejogos.Game.listGames

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.Game.GameDetails.GamesDetailsActivity
import com.example.victor.mobilejogos.R
import kotlinx.android.synthetic.main.activity_list_games.*
import java.io.Serializable

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListGamesFragment : Fragment(), ListGamesContract.View, OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    lateinit var presenter: ListGamesPresenter
    lateinit var adapter: ListGamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onClick(game: Game) {
        val intent = Intent(this, GamesDetailsActivity::class.java)
        intent.putExtra(GamesDetailsActivity.gameExtra, game as Serializable)
        startActivity(intent)
    }

    override fun displayListGames(listGames: List<Game>) {
        progressbar.visibility = View.GONE
        adapter.setData(listGames)
        adapter.setOnItemClickListener(this)
        rvGames.adapter = adapter
    }

    override fun setMessage() {
        Toast.makeText(context, "Falha no acesso ao servidor", Toast.LENGTH_SHORT).show()
        progressbar.visibility = View.GONE
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        adapter = ListGamesAdapter(context)
        rvGames.layoutManager = LinearLayoutManager(context)
        rvGames.adapter = adapter
        presenter = ListGamesPresenter(this)
        presenter.getListGames()

        return inflater.inflate(R.layout.fragment_list_games, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListGamesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ListGamesFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
