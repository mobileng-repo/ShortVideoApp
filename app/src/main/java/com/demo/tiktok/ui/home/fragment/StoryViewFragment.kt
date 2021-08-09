package com.demo.tiktok.ui.home.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.demo.tiktok.R
import com.demo.tiktok.app.MyApp
import com.demo.tiktok.databinding.FragmentStoryviewBinding
import com.demo.tiktok.ui.home.model.VideoState
import com.demo.tiktok.utils.Constants
import com.demo.tiktok.utils.MyBounceInterpolator
import com.demo.tiktok.utils.formatNumberAsReadableFormat
import com.demo.tiktok.utils.setTextOrHide

class StoryViewFragment : Fragment() {
    private var storyUrl: String? = null
    private var videoList: VideoState? = null
    private var simplePlayer: SimpleExoPlayer? = null
    private var cacheDataSourceFactory: CacheDataSourceFactory? = null
    private val simpleCache = MyApp.simpleCache
    private lateinit var binding: FragmentStoryviewBinding

    companion object {
        fun newInstance(videoList: VideoState) = StoryViewFragment()
            .apply {
                arguments = Bundle().apply {
                    putParcelable(Constants.KEY_STORY_DATA, videoList)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStoryviewBinding.inflate(layoutInflater, container, false)
        videoList = arguments?.getParcelable(Constants.KEY_STORY_DATA)
        setData()
        return binding.root
    }

    private fun setData() {
        binding.tvUserName.setTextOrHide(value = videoList?.userName)
        binding.tvDescription.setTextOrHide(value = videoList?.storyDescription)
        binding.imageViewOptionCommentTitle.text =
            videoList?.commentsCount?.formatNumberAsReadableFormat()
        binding.imageViewOptionLikeTitle.text =
            videoList?.likesCount?.formatNumberAsReadableFormat()

        //Todo:: Play Music from here
        val simplePlayer = getPlayer()
        binding.playerViewStory.player = simplePlayer
        storyUrl = videoList?.storyUrl
        storyUrl?.let { prepareMedia(it) }

        //Todo:: Button for like and dislike
        binding.btnLikeDislike.setOnClickListener {
            if(videoList!!.isLiked){
                binding.btnLikeDislike.setImageDrawable(ContextCompat.getDrawable(requireContext(),
                    R.drawable.ic_dislike))
                videoList!!.isLiked = false
            }else {
                videoList!!.isLiked = true
                val myAnim: Animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
                val interpolator = MyBounceInterpolator(0.1, 15.0)
                myAnim.interpolator = interpolator
                binding.btnLikeDislike.startAnimation(myAnim)
                binding.btnLikeDislike.setImageDrawable(ContextCompat.getDrawable(requireContext(),
                    R.drawable.ic_heart_icon))
            }
        }

        //Todo:: Tap to mute and un-mute from here
        binding.layoutDetails.setOnClickListener{
            setVideoSound()
        }
    }

    override fun onPause() {
        pauseVideo()
        super.onPause()
    }

    override fun onResume() {
        restartVideo()
        super.onResume()
    }

    override fun onDestroy() {
        releasePlayer()
        super.onDestroy()
    }

    private fun prepareVideoPlayer() {
        simplePlayer = ExoPlayerFactory.newSimpleInstance(context)
        cacheDataSourceFactory = CacheDataSourceFactory(simpleCache,
            DefaultHttpDataSourceFactory(
                Util.getUserAgent(context,"exo"))
        )
    }

    private fun getPlayer(): SimpleExoPlayer? {
        if (simplePlayer == null) {
            prepareVideoPlayer()
        }
        return simplePlayer
    }

    private fun prepareMedia(linkUrl: String) {
        val uri = Uri.parse(linkUrl)
        val mediaSource =
            ProgressiveMediaSource.Factory(cacheDataSourceFactory).createMediaSource(uri)
        simplePlayer?.prepare(mediaSource, true, true)
        simplePlayer?.repeatMode = Player.REPEAT_MODE_ALL
        simplePlayer?.playWhenReady = true
    }

    private fun restartVideo() {
        if (simplePlayer == null) {
            storyUrl?.let { prepareMedia(it) }
        } else {
            simplePlayer?.playWhenReady = true
            simplePlayer?.playbackState
        }
    }

    private fun setVideoSound(){
        val currentVol = simplePlayer?.volume
        if (currentVol == 0f) {
            videoList?.isMute = false
            simplePlayer?.volume = 1f
        } else {
            videoList?.isMute = true
            simplePlayer?.volume = 0f
        }
    }

    private fun pauseVideo() {
        simplePlayer?.playWhenReady = false
    }

    private fun releasePlayer() {
        simplePlayer?.stop(true)
        simplePlayer?.release()
    }
}