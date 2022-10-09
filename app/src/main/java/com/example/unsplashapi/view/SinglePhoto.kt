package com.example.unsplashapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.unsplashapi.R
import com.example.unsplashapi.databinding.SinglePhotoBinding
import com.example.unsplashapi.viewmodel.AppViewModel

class SinglePhoto : Fragment(R.layout.single_photo) {

    private val appViewModel: AppViewModel by activityViewModels()
    private var _binding: SinglePhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SinglePhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fullSizePhoto.load(appViewModel.clickedPhotoFullUrl) {
            listener(
                onStart = {
                    binding.progressBar.visibility = View.VISIBLE
                },

                onSuccess = { request, result ->
                    binding.progressBar.visibility = View.INVISIBLE
                }
            )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}