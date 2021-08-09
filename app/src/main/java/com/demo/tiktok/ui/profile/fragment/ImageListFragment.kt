package com.demo.tiktok.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.tiktok.databinding.FragmentImagesBinding
import com.demo.tiktok.ui.profile.adapter.ImageListAdapter
import com.demo.tiktok.ui.profile.model.ImageListState
import com.demo.tiktok.ui.profile.viewModel.ImageListViewModel

class ImageListFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding

    private val imageList: ArrayList<ImageListState> = ArrayList()
    private lateinit var imageListViewModel: ImageListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagesBinding.inflate(inflater,container,false)

        //Todo:: Get data from ViewModel and set into adapter class
        imageListViewModel = ViewModelProvider(this@ImageListFragment).get(ImageListViewModel::class.java)
        imageList.addAll(imageListViewModel.getImageList())
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = ImageListAdapter(imageList,requireContext())

        return binding.root
    }
}