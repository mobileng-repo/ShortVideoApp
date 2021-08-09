package com.demo.tiktok.ui.profile.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.demo.tiktok.R
import com.demo.tiktok.databinding.ProfileDetailsBinding
import com.demo.tiktok.ui.profile.listener.TABOnClickListener
import com.demo.tiktok.ui.profile.model.ProfileDetailsState
import com.demo.tiktok.utils.Constants
import com.demo.tiktok.utils.formatNumberAsReadableFormat

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_MATCH_HEIGHT)
class ProfileDetailsView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle), TABOnClickListener {
    private var onBtnClickLister: (String) -> Unit = {}

    private var binding: ProfileDetailsBinding = ProfileDetailsBinding.inflate(
        LayoutInflater.from(context), this, false
    )

    init {
        addView(binding.root)
    }

    @ModelProp
    fun handleStateFor(state: ProfileDetailsState) {
        binding.toolbar.tvToolbarTitle.text = resources.getString(R.string.app_name)
        binding.tvTitle.text = state.userName
        binding.tvFollowers.text = state.totalFollowers.toLong().formatNumberAsReadableFormat()
        binding.tvFollowing.text = state.totalFollowing.toLong().formatNumberAsReadableFormat()
        binding.tvDescription.text = state.description

        binding.btnImageGallary.setOnClickListener{
            onBtnClickLister(Constants.IMAGE_LIST)
        }

        binding.btnVideoGallary.setOnClickListener{
            onBtnClickLister(Constants.VIDEO_LIST)
        }

        binding.toolbar.btnBack.setOnClickListener{
            onBtnClickLister(Constants.BTN_BACK)
        }
    }

    @ModelProp(ModelProp.Option.DoNotHash)
    override fun setOnTABClickLister(listener: (String) -> Unit) {
        this.onBtnClickLister = listener
    }
}