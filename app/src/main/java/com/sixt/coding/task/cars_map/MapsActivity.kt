package com.sixt.coding.task.cars_map

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseActivity
import com.sixt.coding.task.databinding.ActivityMapsBinding

class MapsActivity : BaseActivity<MapViewModel, ActivityMapsBinding>(), LifecycleOwner {

    override fun getViewModel(): Class<MapViewModel> {
        return MapViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.activity_maps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.callMap(this@MapsActivity)
    }

}
