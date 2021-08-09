package com.demo.tiktok.ui.home.controller

import com.airbnb.epoxy.EpoxyController
import com.demo.tiktok.ui.home.model.VideoModelState
import com.demo.tiktok.ui.home.view.storyView

class StoryViewEpoxyController: EpoxyController() {

    private var videoModelState : VideoModelState? = null
    fun setStoryViewState(stateModel: VideoModelState?) {
        videoModelState =  stateModel
        requestModelBuild()
    }

    override fun buildModels() {
        videoModelState?.videoList?.forEach {
            storyView {
                id(it.hashCode())
                handleStateFor(it)
                onLastVideoItemSelectedListener {
                }
            }
        }
    }
}