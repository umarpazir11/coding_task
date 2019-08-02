package com.sixt.coding.task

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.sixt.coding.task.base.BaseActivity
import com.sixt.coding.task.cars_map.MapFragment
import com.sixt.coding.task.databinding.ActivityMapsBinding

class HomeActivity : BaseActivity<ActivityMapsBinding>(), LifecycleOwner {

    override val layoutRes: Int
        get() = R.layout.activity_maps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mapFragment = MapFragment()
        val fragmentManager: FragmentManager = this.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, mapFragment)
        transaction.commit()
    }
}
