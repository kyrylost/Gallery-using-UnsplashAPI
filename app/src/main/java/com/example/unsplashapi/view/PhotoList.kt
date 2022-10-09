package com.example.unsplashapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.unsplashapi.R
import com.example.unsplashapi.databinding.PhotoListBinding
import com.example.unsplashapi.viewmodel.AppViewModel


class PhotoList : Fragment(R.layout.photo_list) {

    private val appViewModel: AppViewModel by activityViewModels()
    private var _binding: PhotoListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PhotoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appViewModel.getPhotos()

        appViewModel.processedData.observe(viewLifecycleOwner) { dataList ->
            binding.photosRecyclerView.apply {
                val photoAdapter = PhotoAdapter(dataList)
                layoutManager = GridLayoutManager(context, 3)
                adapter = photoAdapter

                photoAdapter.onItemClick = { url ->
                    appViewModel.clickedPhotoFullUrl = url

                    val nextFrag = SinglePhoto()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}