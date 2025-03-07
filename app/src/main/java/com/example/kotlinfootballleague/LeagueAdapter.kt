package com.example.kotlinfootballleague

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(private val context: Context, private val items: MutableList<LeagueParcelable>, private val listener:(LeagueParcelable) ->Unit )
    : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LeagueUI().createView(AnkoContext.Companion.create(context,parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        var tvName: TextView = itemView.findViewById(LeagueUI.tvLeagueName)
        var ivImage: ImageView = itemView.findViewById(LeagueUI.ivLeagueImage)

        fun bindItem(items: LeagueParcelable, listener: (LeagueParcelable) -> Unit) {
            tvName.text = items.name

            val tempImage:Int = items.image!!
            ivImage.setImageResource(tempImage)

            containerView.setOnClickListener { listener(items) }
        }
    }
}