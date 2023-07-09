package com.example.posts.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.posts.AppListener

open class BaseFragment : Fragment() {

    private lateinit var listener: AppListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AppListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModel()?.loading?.observe(viewLifecycleOwner) {
            showProgress(it)
        }

        getViewModel()?.message?.observe(viewLifecycleOwner) {
            showMessage(it)
        }

    }

    open fun getViewModel(): BaseViewModel? {
        return null
    }

    protected open fun showProgress(show: Boolean) {
        if (show) {
            listener.showProgress()
        } else {
            listener.hideProgress()
        }
    }

    protected fun showMessage(message: String?) {
        listener.showMessage(message)
    }

}