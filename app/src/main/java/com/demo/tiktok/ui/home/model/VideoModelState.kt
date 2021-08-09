package com.demo.tiktok.ui.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoState(
    val storyId: Long,
    val storyUrl: String,
    val storyDescription: String? = null,
    val userId: Int,
    val userProfilePicUrl: String? = null,
    val userName: String,
    val likesCount: Long,
    val commentsCount: Long,
    var isLiked: Boolean = false,
    var isMute: Boolean = false
) : Parcelable

@Parcelize
data class VideoModelState(
    val videoList: List<VideoState> = emptyList(),
) : Parcelable