package com.example.posts.ui.postslist

import androidx.recyclerview.widget.RecyclerView
import com.example.posts.data.models.Post
import com.example.posts.databinding.ItemViewPostBinding

class PostViewHolder(
    private val binding: ItemViewPostBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.item = post
    }

}