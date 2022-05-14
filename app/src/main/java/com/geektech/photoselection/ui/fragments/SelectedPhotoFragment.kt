package com.geektech.photoselection.ui.fragments

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.photoselection.R
import com.geektech.photoselection.base.BaseFragment
import com.geektech.photoselection.common.extensions.submitData
import com.geektech.photoselection.databinding.FragmentSelectedPhotoBinding
import kotlinx.coroutines.launch


class SelectedPhotoFragment :
    BaseFragment<FragmentSelectedPhotoBinding>(R.layout.fragment_selected_photo) {
    override val binding by viewBinding(FragmentSelectedPhotoBinding::bind)
    private val viewModel: PhotosViewModel by activityViewModels()
    private val photosAdapter = PhotosAdapter()

    override fun initViews() {
        setupAdapter()
    }

    override fun initListeners() {
        binding.btnArrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setupAdapter() {
        binding.recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        binding.recyclerview.adapter = photosAdapter
        binding.recyclerview.layoutManager = GridLayoutManager(context, 3)
    }

    override fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listState.observe(viewLifecycleOwner) { list ->
                photosAdapter.submitData(list)
            }
        }
    }
}
