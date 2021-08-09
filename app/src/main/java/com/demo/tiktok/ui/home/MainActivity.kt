package com.demo.tiktok.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.airbnb.epoxy.EpoxyController
import com.demo.tiktok.ui.home.adapter.StoriesPagerAdapter
import com.demo.tiktok.databinding.ActivityHomeBinding
import com.demo.tiktok.ui.home.model.VideoModelState
import com.demo.tiktok.ui.home.model.VideoState
import com.demo.tiktok.ui.home.controller.StoryViewEpoxyController
import com.demo.tiktok.ui.home.viewModel.VideoListViewModel
import com.demo.tiktok.ui.profile.ProfileActivity
import com.demo.tiktok.utils.Constants
import com.demo.tiktok.utils.work.PreCachingService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val videoList: ArrayList<VideoState> = ArrayList()
    private lateinit var storyViewEpoxyController: StoryViewEpoxyController
    private var videoModelState: VideoModelState? = null
    private lateinit var storiesPagerAdapter: StoriesPagerAdapter
    private lateinit var videoListViewModel: VideoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Todo:: Clear catch every time when application is run
        cacheDir.deleteRecursively()

        //Todo:: Initialize Epoxy controller and set with viewpager
        storyViewEpoxyController = StoryViewEpoxyController()
        binding.viewpager.setController(storyViewEpoxyController)

        //Todo:: Get Data from ViewModel class and set into viewpager using epoxy recyclerview
        videoListViewModel = ViewModelProvider(this@MainActivity).get(VideoListViewModel::class.java)
        videoList.addAll(videoListViewModel.getVideoList())
        videoList.let { videoModelState = VideoModelState(it) }
        storyViewEpoxyController.setStoryViewState(videoModelState)

        storiesPagerAdapter = StoriesPagerAdapter(this, videoList)
        binding.viewpager.adapter = storiesPagerAdapter

        //Todo:: Start to catching all the video data
        startPreCaching(videoList)

        binding.toolbar.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    //Todo:: Start to catching all the video data
    private fun startPreCaching(dataListState: ArrayList<VideoState>) {
        val urlList = arrayOfNulls<String>(dataListState.size)
        dataListState.mapIndexed { index, storiesDataModel ->
            urlList[index] = storiesDataModel.storyUrl
        }
        val inputData =
            Data.Builder().putStringArray(Constants.KEY_STORIES_LIST_DATA, urlList).build()
        val preCachingWork = OneTimeWorkRequestBuilder<PreCachingService>().setInputData(inputData)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(preCachingWork)
    }

    private fun ViewPager2.setController(controller: EpoxyController) {
        adapter = controller.adapter
    }
}