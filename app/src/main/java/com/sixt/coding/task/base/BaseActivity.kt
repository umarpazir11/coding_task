package com.sixt.coding.task.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * File Description
 *
 * Author: Umer
 */
 abstract class BaseActivity<D : ViewDataBinding> : DaggerAppCompatActivity(), HasSupportFragmentInjector {
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    //lateinit var viewModel: V

    lateinit var binding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    //protected abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        //viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }
}

