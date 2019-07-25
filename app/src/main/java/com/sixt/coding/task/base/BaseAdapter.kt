package com.sixt.coding.task.base

import androidx.recyclerview.widget.RecyclerView


/**
 * File Description
 *
 * Author: Umer
 */
abstract class BaseAdapter<T : RecyclerView.ViewHolder, D> : RecyclerView.Adapter<T>() {

    abstract fun setData(data: List<D>)
}