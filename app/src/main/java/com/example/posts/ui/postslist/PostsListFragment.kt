package com.example.posts.ui.postslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posts.data.models.Post
import com.example.posts.databinding.FragmentPostsListBinding
import com.example.posts.ui.base.BaseFragment
import com.example.posts.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "PostsListFragment"

@AndroidEntryPoint
class PostsListFragment : BaseFragment() {

    private lateinit var binding: FragmentPostsListBinding

    private val viewModel: PostsListViewModel by viewModels()
    private val postsAdapter = PostsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        postsAdapter.setOnItemClickListener(object :
            PostsAdapter.OnItemClickListener {
            override fun onItemClicked(view: View, item: Post, position: Int) {
                val action =
                    PostsListFragmentDirections.actionPostsListFragmentToPostDetailsFragment(item.id)
                findNavController().navigate(action)
            }
        })

        viewModel.posts.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: posts : $it")
            postsAdapter.clear()
            postsAdapter.setItems(it)
        }

        viewModel.getPosts()
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

}