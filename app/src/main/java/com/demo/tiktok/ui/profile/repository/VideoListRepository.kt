package com.demo.tiktok.ui.profile.repository
import com.demo.tiktok.ui.profile.model.ImageListState

class VideoListRepository {
    private val videoList: MutableList<ImageListState> = ArrayList()

    fun getVideoList(): MutableList<ImageListState> {
        return videoList
    }

    companion object {
        private var videoListRepository: VideoListRepository? = null
        val instance: VideoListRepository?
            get() {
                if (videoListRepository == null) {
                    videoListRepository = VideoListRepository()
                }
                return videoListRepository
            }
    }

    init {
        //Todo:: Add static data for a Images
        addStaticImageData()
    }

    //Todo:: Add static data for a video
    private fun addStaticImageData() {
        videoList.add(ImageListState(1,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-557.mp4",
            "35",
            10,
            "5"))
        videoList.add(ImageListState(2,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-556.mp4",
            "200",
            25,
            "245"))
        videoList.add(ImageListState(3,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-555.mp4",
            "547",
            3,
            "52"))
        videoList.add(ImageListState(4,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-549.mp4",
            "333",
            4,
            "523"))
        videoList.add(ImageListState(5,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-537.mp4",
            "678",
            5,
            "9562"))
        videoList.add(ImageListState(6,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-534.mp4",
            "346",
            6,
            "563"))
        videoList.add(ImageListState(7,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-529.mp4",
            "344",
            7,
            "92"))
    }
}