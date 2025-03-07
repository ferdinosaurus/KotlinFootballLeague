package com.example.kotlinfootballleague

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import org.jetbrains.anko.*

class LeagueUI: AnkoComponent<ViewGroup> {

    companion object {
        val tvLeagueName = 1
        val ivLeagueImage = 2

    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)

            padding = dip(16)

            imageView{

                id = ivLeagueImage
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }.lparams{
                width = 500
                height = 500
                gravity = Gravity.CENTER
            }
            textView {
                id = tvLeagueName
                text = "Club Name"
                textSize = 20F
                textColor = ContextCompat.getColor(context,R.color.colorPrimaryDark)
                gravity = Gravity.CENTER
            }.lparams{
                width = matchParent
                height = wrapContent
                topMargin = 5
            }

        }
    }
}