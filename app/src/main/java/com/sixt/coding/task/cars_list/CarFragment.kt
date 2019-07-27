package com.sixt.coding.task.cars_list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseFragment
import com.sixt.coding.task.databinding.FragmentCarListBinding

/**
 * A fragment representing a list of Items.
 */
class CarFragment : BaseFragment<CarsListViewModel, FragmentCarListBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_car_list

    override fun getViewModel(): Class<CarsListViewModel> {
        return CarsListViewModel::class.java
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set the adapter
        //binding.list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.lifecycleOwner = this
        val layoutManager = LinearLayoutManager(context)
        binding.list.hasFixedSize()
        binding.list.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        binding.viewModel = viewModel


       // observeData()
       // viewModel.getCars()

    }

//    private fun observeData() {
//        viewModel.cars
//            .observe(this, Observer {
//                it?.let {
//                    if (it.size > 0) {
//                        val adapter = MyCarRecyclerViewAdapter()
//                        binding.list.adapter = adapter
//                    }else{
//                        Toast.makeText(activity,"No Data Found",Toast.LENGTH_LONG).show()
//                    }
//                }
//            })
//    }
}
