package com.sixt.coding.task.cars_list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseAdapter
import com.sixt.coding.task.databinding.FragmentCarBinding
import com.sixt.coding.task.model.Car

/**
 * [RecyclerView.Adapter] that can display a [Car]
 */
//RecyclerView.Adapter<MyCarRecyclerViewAdapter.ViewHolder>()
class MyCarRecyclerViewAdapter : BaseAdapter<MyCarRecyclerViewAdapter.ViewHolder,RecyclerView>() {
    override fun setData(data: List<RecyclerView>) {
    }

    lateinit var carList: List<Car>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentCarBinding>(layoutInflater, R.layout.fragment_car, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = carList[position]
        //holder.binding.car = carList[position]
        holder.binding.tvMake.text = item.make
        holder.binding.tvName.text = item.name

    }
    override fun getItemCount(): Int {
        return if(::carList.isInitialized) carList.size else 0
    }

    inner class ViewHolder(val binding: FragmentCarBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateCarList(carList: List<Car>){
        this.carList = carList
        notifyDataSetChanged()
    }
}
