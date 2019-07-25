package com.sixt.coding.task.cars_list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseFragment

import com.sixt.coding.task.cars_list.dummy.DummyContent
import com.sixt.coding.task.cars_list.dummy.DummyContent.DummyItem
import com.sixt.coding.task.databinding.FragmentCarListBinding

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [CarFragment.OnListFragmentInteractionListener] interface.
 */
class CarFragment : BaseFragment<CarsListViewModel, FragmentCarListBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_car_list

    override fun getViewModel(): Class<CarsListViewModel> {
        return CarsListViewModel::class.java
    }

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_car_list, container, false)
//
//        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = MyCarRecyclerViewAdapter(DummyContent.ITEMS, listener)
//            }
//        }
//        return view
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

}
