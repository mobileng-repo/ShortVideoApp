package com.demo.tiktok.ui.profile.viewModel

import androidx.lifecycle.ViewModel
import com.demo.tiktok.ui.profile.model.ImageListState
import com.demo.tiktok.ui.profile.repository.ImageListRepository

class ImageListViewModel : ViewModel() {
    private var imageListRepository: ImageListRepository = ImageListRepository()
    private var imageList: MutableList<ImageListState> = imageListRepository.getImageList()

    //Todo:: Get Image list from Repository class
    fun getImageList(): MutableList<ImageListState> {
        return imageList
    }
}