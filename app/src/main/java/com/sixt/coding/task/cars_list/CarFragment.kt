package com.sixt.coding.task.cars_list

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseFragment
import com.sixt.coding.task.databinding.FragmentCarListBinding
import dagger.android.support.DaggerAppCompatActivity

/**
 * A fragment representing a list of Cars.
 */
class CarFragment : BaseFragment<CarsListViewModel, FragmentCarListBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_car_list

    override fun getViewModel(): Class<CarsListViewModel> {
        return CarsListViewModel::class.java
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity is DaggerAppCompatActivity){
            (activity as DaggerAppCompatActivity).setSupportActionBar(binding.toolbar)
        }
        binding.toolbar.setNavigationIcon(R.drawable.ic_back_button)
        binding.lifecycleOwner = this
        val layoutManager = LinearLayoutManager(context)
        binding.list.hasFixedSize()
        binding.list.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        binding.viewModel = viewModel

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity!!.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
