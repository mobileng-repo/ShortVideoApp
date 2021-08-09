package com.demo.tiktok.ui.profile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.tiktok.R
import com.demo.tiktok.databinding.RowImageItemBinding
import com.demo.tiktok.ui.profile.model.ImageListState
import com.demo.tiktok.utils.Utility

class VideoListAdapter(private val videoList: ArrayList<ImageListState>, val context: Context) : RecyclerView.Adapter<VideoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_image_item, parent, false)
        return ViewHolder(v)
    }
 
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            Utility.loadThumbnail(videoList[position].url,binding.imageview)
            binding.tvTotalView.text = videoList[position].viewCount
            binding.tvTotalLikes.text = videoList[position].likesCount.toString()
            binding.tvTotalComments.text = videoList[position].commentsCount
            binding.ivVideoIcon.visibility = View.VISIBLE
        }
    }
 
    override fun getItemCount(): Int {
        return videoList.size
    }
 
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RowImageItemBinding.bind(itemView)
    }
}