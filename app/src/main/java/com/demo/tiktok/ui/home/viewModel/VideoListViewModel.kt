package com.demo.tiktok.ui.home.viewModel

import androidx.lifecycle.ViewModel
import com.demo.tiktok.ui.home.model.VideoState
import com.demo.tiktok.ui.home.repository.VideoListRepository

class VideoListViewModel : ViewModel() {

    private var videoListRepository: VideoListRepository = VideoListRepository()
    private var videoList: MutableList<VideoState> = videoListRepository.getVideoList()

    //Todo:: Get video list from Repository class
    fun getVideoList(): MutableList<VideoState> {
        return videoList
    }
}