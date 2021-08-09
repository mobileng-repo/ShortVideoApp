package com.demo.tiktok.ui.profile.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.demo.tiktok.databinding.ProfilePostlistBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ProfilePostListView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {

    private var binding: ProfilePostlistBinding = ProfilePostlistBinding.inflate(
        LayoutInflater.from(context), this, false
    )

    init {
        addView(binding.root)
    }
}