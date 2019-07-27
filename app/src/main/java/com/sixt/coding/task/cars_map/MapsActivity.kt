package com.sixt.coding.task.cars_map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sixt.coding.task.R
import com.sixt.coding.task.base.BaseActivity
import com.sixt.coding.task.cars_list.CarFragment
import com.sixt.coding.task.databinding.ActivityMapsBinding
import com.sixt.coding.task.model.Car

class MapsActivity : BaseActivity<MapViewModel,ActivityMapsBinding>(), LifecycleOwner, OnMapReadyCallback {

//    override fun onListFragmentInteraction(item: Car) {
//
//    }

    override fun getViewModel(): Class<MapViewModel> {
        return MapViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.activity_maps

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getCars()

        binding.floatingActionButton.setOnClickListener {
            val carFragment = CarFragment()
            val fragmentManager: FragmentManager = this.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.addToBackStack(null)
            transaction.replace(R.id.map,carFragment)
            transaction.commit()

        }


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
