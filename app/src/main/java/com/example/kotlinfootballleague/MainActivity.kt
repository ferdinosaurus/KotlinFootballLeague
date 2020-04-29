package com.example.kotlinfootballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var leagueParcelables: MutableList<LeagueParcelable> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        //MainActivityUI().setContentView(this)
    }

    private fun initData(){
        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueImage = resources.obtainTypedArray(R.array.league_image)
        val leagueDesc = resources.getStringArray(R.array.league_desc)


        for (i in leagueName.indices){
            leagueParcelables.add(LeagueParcelable(leagueName.get(i),leagueImage.getResourceId(i,0),leagueDesc.get(i)))
        }

        verticalLayout {
            padding = dip(16)
            lparams(matchParent, matchParent)
            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = GridLayoutManager(context,2)
                adapter = LeagueAdapter(context,leagueParcelables){
                    startActivity<DetailActivity>("leagueParcelable" to it)
                }
            }
        }
    }
}
