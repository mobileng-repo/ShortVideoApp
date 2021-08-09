package com.demo.tiktok.utils

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.IOException
import java.util.*

object Utility {
    private val suffixes: NavigableMap<Long, String> = TreeMap()
    private fun setSuffixes() {
        suffixes[1_000L] = "k"
        suffixes[1_000_000L] = "M"
        suffixes[1_000_000_000L] = "B"
        suffixes[1_000_000_000_000L] = "T"
        suffixes[1_000_000_000_000_000L] = "P"
        suffixes[1_000_000_000_000_000_000L] = "E"
    }

    fun formatNumberAsNumberFormat(value: Long): String {
        setSuffixes()
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return formatNumberAsNumberFormat(Long.MIN_VALUE + 1)
        if (value < 0) return "-" + formatNumberAsNumberFormat(-value)
        if (value < 1000) return value.toString() //deal with easy case
        val e = suffixes.floorEntry(value)
        val divideBy = e.key
        val suffix = e.value
        val truncated = value / (divideBy / 10) //the number part of the output times 10
        val hasDecimal =
            truncated < 100 && truncated / 10.0 != (truncated / 10).toDouble()
        return if (hasDecimal) (truncated / 10.0).toString() + suffix else (truncated / 10).toString() + suffix
    }

    //Todo:: Load Image using Glide Library
    fun loadImage(context: Context, url: String, imageView:ImageView){
        Glide.with(context)
            .load(url)
            .into(imageView)
    }

    //Todo:: Load thumbnail image from video url
    fun loadThumbnail(url: String, imageView:ImageView){
        try {
            val thread = Thread {
                try {
                    val imageBitmap = getVideoFrameFromVideo(url)
                    imageView.setImageBitmap(imageBitmap)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
            thread.start()
        } catch (e: IOException) {
            println(e)
        }
    }

    @Throws(Throwable::class)
    fun getVideoFrameFromVideo(videoPath: String?): Bitmap? {
        val bitmap: Bitmap?
        var mediaMetadataRetriever: MediaMetadataRetriever? = null
        try {
            mediaMetadataRetriever = MediaMetadataRetriever()
            mediaMetadataRetriever.setDataSource(videoPath, HashMap())
            bitmap = mediaMetadataRetriever.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST)
        } catch (e: Exception) {
            e.printStackTrace()
            throw Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.message)
        } finally {
            mediaMetadataRetriever?.release()
        }
        return bitmap
    }
}