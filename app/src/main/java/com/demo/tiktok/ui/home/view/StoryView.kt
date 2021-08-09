package com.demo.tiktok.ui.home.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.demo.tiktok.app.MyApp
import com.demo.tiktok.databinding.FragmentStoryviewBinding
import com.demo.tiktok.ui.home.model.VideoState
import com.demo.tiktok.utils.formatNumberAsReadableFormat
import com.demo.tiktok.utils.setTextOrHide

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_MATCH_HEIGHT)
class StoryView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {
    private var storyUrl: String? = null
    private var simplePlayer: SimpleExoPlayer? = null
    private var cacheDataSourceFactory: CacheDataSourceFactory? = null
    private val simpleCache = MyApp.simpleCache

    private var binding: FragmentStoryviewBinding = FragmentStoryviewBinding.inflate(
        LayoutInflater.from(context), this, false
    )

    private var setOnLastVideoItemSelectedListener: (VideoState) -> Unit = {}

    init {
        addView(binding.root)
    }

    @ModelProp(ModelProp.Option.DoNotHash)
    fun setOnLastVideoItemSelectedListener(listener: (VideoState) -> Unit) {
        setOnLastVideoItemSelectedListener = listener
    }

    @ModelProp(ModelProp.Option.DoNotHash)
    fun handleStateFor(state: VideoState) {
        binding.tvUserName.setTextOrHide(value = state.userName)
        binding.tvDescription.setTextOrHide(value = state.storyDescription)
        binding.imageViewOptionCommentTitle.text =
            state.commentsCount.formatNumberAsReadableFormat()
        binding.imageViewOptionLikeTitle.text =
            state.likesCount.formatNumberAsReadableFormat()

        val simplePlayer = getPlayer()
        binding.playerViewStory.player = simplePlayer
        storyUrl = state.storyUrl
        storyUrl?.let { prepareMedia(it) }
    }

    private fun getPlayer(): SimpleExoPlayer? {
        if (simplePlayer == null) {
            prepareVideoPlayer()
        }
        return simplePlayer
    }

    private fun prepareVideoPlayer() {
        simplePlayer = ExoPlayerFactory.newSimpleInstance(context)
        cacheDataSourceFactory = CacheDataSourceFactory(
            simpleCache, DefaultHttpDataSourceFactory(Util.getUserAgent(context, "exo"))
        )
    }

    private fun prepareMedia(linkUrl: String) {
        val uri = Uri.parse(linkUrl)
        val mediaSource =
            ProgressiveMediaSource.Factory(cacheDataSourceFactory).createMediaSource(uri)
        simplePlayer?.prepare(mediaSource, true, true)
        simplePlayer?.repeatMode = Player.REPEAT_MODE_ONE
        simplePlayer?.playWhenReady = true
    }
}