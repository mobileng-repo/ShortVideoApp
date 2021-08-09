package com.demo.tiktok.ui.profile.repository
import com.demo.tiktok.ui.profile.model.ImageListState

class ImageListRepository {
    private val imagesList: MutableList<ImageListState> = ArrayList()

    fun getImageList(): MutableList<ImageListState> {
        return imagesList
    }

    companion object {
        private var imageListRepository: ImageListRepository? = null
        val instance: ImageListRepository?
            get() {
                if (imageListRepository == null) {
                    imageListRepository = ImageListRepository()
                }
                return imageListRepository
            }
    }

    init {
        //Todo:: Add static data for a Images
        addStaticImageData()
    }

    //Todo:: Add static data for a video
    private fun addStaticImageData() {
        imagesList.add(ImageListState(1,
            "https://picsum.photos/200/300",
            "35",
            10,
            "5"))
        imagesList.add(ImageListState(2,
            "https://picsum.photos/id/237/200/300",
            "200",
            25,
            "245"))
        imagesList.add(ImageListState(3,
            "https://picsum.photos/seed/picsum/200/300",
            "547",
            3,
            "52"))
        imagesList.add(ImageListState(4,
            "https://picsum.photos/200/300?grayscale",
            "333",
            4,
            "523"))
        imagesList.add(ImageListState(5,
            "https://picsum.photos/200/300/?blur=2",
            "678",
            5,
            "9562"))
        imagesList.add(ImageListState(6,
            "https://picsum.photos/id/870/200/300?grayscale&blur=2",
            "346",
            6,
            "563"))
        imagesList.add(ImageListState(7,
            "https://picsum.photos/id/870/200/300?grayscale&blur=2",
            "344",
            7,
            "92"))
        imagesList.add(ImageListState(8,
            "https://picsum.photos/id/870/200/300?grayscale&blur=2",
            "645",
            8,
            "96"))
        imagesList.add(ImageListState(9,
            "https://picsum.photos/id/870/200/300?grayscale&blur=2",
            "534",
            9,
            "222"))
    }
}