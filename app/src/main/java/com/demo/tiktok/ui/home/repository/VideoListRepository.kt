package com.demo.tiktok.ui.home.repository

import com.demo.tiktok.ui.home.model.VideoState

class VideoListRepository {
    private val videoList: MutableList<VideoState> = ArrayList()

    fun getVideoList(): MutableList<VideoState> {
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
        //Todo:: Add static data for a video
        addStaticData()
    }

    //Todo:: Add static data for a video
    private fun addStaticData() {
        videoList.add(VideoState(1,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-557.mp4",
            "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
            1,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Hiren Patel",
            500,
            1500))
        videoList.add(VideoState(2,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-556.mp4",
            "#besafe #motivation #life",
            2,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Ankit",
            5005,
            15700))
        videoList.add(VideoState(3,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-555.mp4",
            "#motivation #life #lockdown",
            3,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Bhargav",
            520,
            1600))
        videoList.add(VideoState(4,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-549.mp4",
            "#motivation #life #lockdown",
            4,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Sunil",
            520,
            1600))
        videoList.add(VideoState(5,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-537.mp4",
            "Baby Girl 4k HD Full Screen Whatsapp Status Video",
            5,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Hardik",
            520,
            1600))
        videoList.add(VideoState(6,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-534.mp4",
            "Kinna Sona 4k Full Screen Whatsapp Status Video",
            6,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "John",
            520,
            1600))
        videoList.add(VideoState(7,
            "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-529.mp4",
            "Love Me Thoda Aur 4k Full Screen Status Video Download",
            7,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Hiren",
            520,
            1600))
        videoList.add(VideoState(8,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            "#motivation #life #lockdown",
            8,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "James",
            520,
            1600))
        videoList.add(VideoState(9,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
            "#motivation #life #lockdown",
            9,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Milan",
            520,
            1600))
        videoList.add(VideoState(10,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
            "#motivation #life #lockdown",
            10,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Hiren Patel",
            520,
            1600))
        videoList.add(VideoState(11,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
            "#motivation #life #lockdown",
            11,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Vivan",
            520,
            1600))
        videoList.add(VideoState(12,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            "#motivation #life #lockdown",
            12,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Kamal",
            520,
            1600))
        videoList.add(VideoState(13,
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4",
            "#motivation #life #lockdown",
            13,
            "https://res.cloudinary.com/mydatacloud/image/upload/v1592823557/profiles/user_3_dzxh4b.jpg",
            "Vishal",
            520,
            1600))
    }
}