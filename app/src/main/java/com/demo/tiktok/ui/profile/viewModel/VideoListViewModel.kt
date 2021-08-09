package com.demo.tiktok.ui.profile.viewModel

import androidx.lifecycle.ViewModel
import com.demo.tiktok.ui.profile.model.ImageListState
import com.demo.tiktok.ui.profile.repository.VideoListRepository


class VideoListViewModel : ViewModel() {
    private var videoListRepository: VideoListRepository = VideoListRepository()
    private var videoList: MutableList<ImageListState> = videoListRepository.getVideoList()

    //Todo:: Get video list from Repository class
    fun getVideoList(): MutableList<ImageListState> {
        return videoList
    }
}