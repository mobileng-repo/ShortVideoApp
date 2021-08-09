package com.demo.tiktok.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.tiktok.databinding.ActivityProfileBinding
import com.demo.tiktok.ui.profile.adapter.ViewPagerAdapter
import com.demo.tiktok.ui.profile.controller.ProfileEpoxyController
import com.demo.tiktok.ui.profile.fragment.ImageListFragment
import com.demo.tiktok.ui.profile.fragment.VideoListFragment
import com.demo.tiktok.ui.profile.model.ProfileDetailsState
import com.demo.tiktok.utils.Constants

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var profileEpoxyController: ProfileEpoxyController
    private var profileDetailsState: ProfileDetailsState? = null
    private var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Todo:: Set Epoxy controller in recyclerview
        profileEpoxyController = ProfileEpoxyController()
        binding.recyclerView.setController(profileEpoxyController)

        //Todo:: Set profile details
        profileDetailsState = ProfileDetailsState(
            "John",
            50000,
            7852524,
            "What is Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industry's standard"
        )
        profileEpoxyController.setProfileDetailsViewState(profileDetailsState)

        //Todo:: Set fragments on viewpager
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter?.add(ImageListFragment())
        viewPagerAdapter?.add(VideoListFragment())
        binding.viewpager.adapter = viewPagerAdapter

        //Todo:: Tabview onclick method
        profileEpoxyController.setOnTABClickLister {
            when (it) {
                Constants.IMAGE_LIST -> {
                    binding.viewpager.currentItem = 0
                }
                Constants.VIDEO_LIST -> {
                    binding.viewpager.currentItem = 1
                }
                else -> {
                    finish()
                }
            }
        }
    }
}