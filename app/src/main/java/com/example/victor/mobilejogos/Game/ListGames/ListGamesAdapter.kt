package com.example.victor.mobilejogos.Game.ListGames

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.victor.mobilejogos.Game.Game
import com.example.victor.mobilejogos.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.game_item_list.*

class ListGamesAdapter(val context: Context) : RecyclerView.Adapter<ListGamesAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null
    var listGames: List<Game>? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listGames?.let {safeListGames->
            val game: Game = safeListGames[position]
            holder.gameImage.setOnClickListener { onItemClickListener?.onClick(safeListGames[position]) }
            Glide.with(context)
                    .load(game.image)
                    .centerCrop()
                    .into(holder.gameImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGamesAdapter.ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return listGames?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer{
        override val containerView: View? = itemView
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    fun setData(listGames:List<Game>){
        this.listGames = listGames
    }
}