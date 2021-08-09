package com.demo.tiktok.ui.profile.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageListState(
    val id: Long,
    val url: String,
    val viewCount: String? = null,
    val likesCount: Int,
    val commentsCount: String? = null
) : Parcelable