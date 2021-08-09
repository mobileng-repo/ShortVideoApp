package com.demo.tiktok.ui.profile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.tiktok.databinding.FragmentVideoBinding
import com.demo.tiktok.ui.profile.adapter.VideoListAdapter
import com.demo.tiktok.ui.profile.model.ImageListState
import com.demo.tiktok.ui.profile.viewModel.VideoListViewModel

class VideoListFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private val videoList: ArrayList<ImageListState> = ArrayList()
    private lateinit var videoListViewModel: VideoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentVideoBinding.inflate(inflater,container,false)

        //Todo:: Get data from ViewModel and set into adapter class
        videoListViewModel = ViewModelProvider(this@VideoListFragment).get(VideoListViewModel::class.java)
        videoList.addAll(videoListViewModel.getVideoList())
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = VideoListAdapter(videoList,requireContext())

        return binding.root
    }
}