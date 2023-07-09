package com.example.posts.ui.postslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.data.models.Post
import com.example.posts.databinding.ItemViewPostBinding

class PostsAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private var posts = mutableListOf<Post>()
    private lateinit var binding: ItemViewPostBinding
    private var onItemClickListener: OnItemClickListener? = null


    fun setItems(items: List<Post>) {
        posts.addAll(items)
        notifyItemRangeInserted(posts.size, items.size)
    }

    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = ItemViewPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(binding)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(it, posts[position], position)
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(view: View, item: Post, position: Int)
    }
}