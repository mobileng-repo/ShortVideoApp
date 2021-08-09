package com.demo.tiktok.ui.profile.controller

import com.airbnb.epoxy.EpoxyController
import com.demo.tiktok.ui.profile.listener.TABOnClickListener
import com.demo.tiktok.ui.profile.model.ProfileDetailsState
import com.demo.tiktok.ui.profile.view.profileDetailsView

class ProfileEpoxyController : EpoxyController(), TABOnClickListener {

    private var profileDetailsState: ProfileDetailsState? = null
    fun setProfileDetailsViewState(detailsState: ProfileDetailsState?) {
        profileDetailsState = detailsState
        requestModelBuild()
    }

    private var tabClickListener: (String) -> Unit = {}
    override fun setOnTABClickLister(listener: (String) -> Unit) {
        this.tabClickListener = listener
    }

    override fun buildModels() {
        profileDetailsState?.let {
            profileDetailsView {
                id(it.hashCode())
                handleStateFor(it)
                onTABClickLister {
                    it.run { tabClickListener(it) }
                }
            }
        }
    }
}