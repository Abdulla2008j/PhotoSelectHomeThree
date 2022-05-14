package com.geektech.photoselection.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>(@LayoutRes layoutId: Int) :
    Fragment(
        layoutId
    ) {
    protected abstract val binding: Binding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        initViews()
        initListeners()
        sendRequest()
        initObservers()
    }

    protected open fun initialize() {
    }

    protected open fun initViews() {
    }

    protected open fun initListeners() {
    }


    protected open fun sendRequest() {
    }


    protected open fun initObservers() {
    }


}