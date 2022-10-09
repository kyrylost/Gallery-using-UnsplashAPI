package com.example.unsplashapi.view

import android.content.res.Resources
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
import com.example.unsplashapi.databinding.RecyclerLayoutInnerViewBinding
import com.example.unsplashapi.model.NeededPhotoData
import com.example.unsplashapi.model.NeededPhotoDataList

class PhotoAdapter (private val neededPhotoDataList : NeededPhotoDataList) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var onItemClick: ((String) -> Unit)? = null

    val width = Resources.getSystem().displayMetrics.widthPixels / 3 -
            (12 * Resources.getSystem().displayMetrics.density).toInt()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = RecyclerLayoutInnerViewBinding.inflate(from, parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val neededPhotoData = neededPhotoDataList[position]

        holder.bindImage(neededPhotoData)
    }

    override fun getItemCount(): Int = neededPhotoDataList.size

    inner class PhotoViewHolder(private val binding: RecyclerLayoutInnerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindImage(neededPhotoData: NeededPhotoData) {

            binding.photoImageView.load(neededPhotoData.smallUrl) {
                crossfade(750)
            }
            binding.username.text = neededPhotoData.username
            binding.description.text = neededPhotoData.description

            binding.photoImageView.layoutParams.height = width
            binding.photoImageView.layoutParams.width = width

            binding.photoImageView.setOnClickListener {
                onItemClick?.invoke(neededPhotoData.fullUrl)
            }
        }
    }
}