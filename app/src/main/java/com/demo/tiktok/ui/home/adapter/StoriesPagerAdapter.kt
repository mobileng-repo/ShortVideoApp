package com.demo.tiktok.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.tiktok.ui.home.model.VideoState
import com.demo.tiktok.ui.home.MainActivity
import com.demo.tiktok.ui.home.fragment.StoryViewFragment

class StoriesPagerAdapter(fragment: MainActivity, private val dataList: MutableList<VideoState> = mutableListOf()) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun createFragment(position: Int): Fragment {
        return StoryViewFragment.newInstance(dataList[position])
    }
}