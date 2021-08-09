package com.demo.tiktok.ui.profile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileDetailsState(
    val userName: String,
    val totalFollowers: Int,
    val totalFollowing: Int,
    val description: String
) : Parcelable