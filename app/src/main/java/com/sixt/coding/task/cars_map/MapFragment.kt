package com.sixt.coding.task.cars_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseFragment
import com.sixt.coding.task.databinding.ActivityMapsBinding

class MapFragment : BaseFragment<MapViewModel, ActivityMapsBinding>(), LifecycleOwner {
    override val layoutRes: Int
        get() = R.layout.map_fragment

    override fun getViewModel(): Class<MapViewModel> {
        return MapViewModel::class.java
    }

    companion object {
        fun newInstance() = MapFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
