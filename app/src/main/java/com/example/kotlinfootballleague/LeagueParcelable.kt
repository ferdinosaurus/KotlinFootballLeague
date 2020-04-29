package com.example.kotlinfootballleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueParcelable (val name: String?, val image: Int?,val desc: String?) : Parcelable {
}