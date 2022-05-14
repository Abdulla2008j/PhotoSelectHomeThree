package com.geektech.photoselection.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.geektech.photoselection.common.extensions.loadWithGlide
import com.geektech.photoselection.data.model.Picture
import com.geektech.photoselection.databinding.ItemImageBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val selectedList = arrayListOf<Picture>()
    private var list = arrayListOf<Picture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun initList(list: ArrayList<Picture>) {
        this.list = list
    }

    inner class ViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: Picture) {
            picture.images?.let { it -> binding.imageView.loadWithGlide(it) }
            binding.root.setOnClickListener {
                if (binding.selectionImage.isInvisible) {
                    binding.selectionImage.isVisible = true
                    selectedList.remove(Picture(picture.images))
                } else {
                    binding.selectionImage.isInvisible = true
                    selectedList.add(Picture(picture.images))

                }
            }
        }
    }
}