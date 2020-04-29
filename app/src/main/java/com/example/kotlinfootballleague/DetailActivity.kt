package com.example.kotlinfootballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val leagueParcelable = intent.getParcelableExtra<LeagueParcelable>("leagueParcelable")



        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                val tempImage:Int = leagueParcelable.image!!
                imageResource = tempImage

            }.lparams{
                width = 250
                height = 250
                gravity = Gravity.CENTER
            }
            scrollView {

                textView {
                    text = leagueParcelable.desc
                }
            }
        }
    }

}
