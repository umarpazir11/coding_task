package com.sixt.coding.task.cars_map

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sixt.coding.task.R
import com.sixt.coding.task.api.repo.CarsRepository
import com.sixt.coding.task.base.BaseViewModel
import com.sixt.coding.task.cars_list.CarFragment
import com.sixt.coding.task.di.module.OBSERVER_ON
import com.sixt.coding.task.di.module.SUBCRIBER_ON
import com.sixt.coding.task.model.Car
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named
import com.google.android.gms.maps.*
import com.google.android.gms.maps.SupportMapFragment




/**
 * A ViewModel used for the {@link MapsActivity}.
 */
class MapViewModel @Inject constructor(
    private val carRepository: CarsRepository,
    @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler) : BaseViewModel(), OnMapReadyCallback {
    lateinit var mMap: GoogleMap

    override fun onMapReady(p0: GoogleMap) {
        this.mMap = p0
        getCars()
    }

    val cars: MutableLiveData<MutableList<Car>?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean?> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()
    var btnVisibility: MutableLiveData<Boolean?> = MutableLiveData()


    init {
        this.isLoading.value = true
        this.btnVisibility.value = true
    }

    fun onFloatingActionButton(v: View) {
        btnVisibility.value = false
        val activity = unwrap(v.context)
        val carFragment = CarFragment()
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.map, carFragment)
        transaction.commit()
    }

    fun callMap(activity: AppCompatActivity) {
        @Suppress("UNCHECKED_CAST")
        val mapFragment = activity.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    fun getCars() {
        this.disposable.addAll(this.carRepository.getCars()
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .doOnSubscribe {
                this.isLoading.value = true
            }
            .doOnComplete {
                this.isLoading.value = false
            }
            .doOnError {
                this.isLoading.value = false
            }
            .subscribe(
                {
                    cars.value = it
                    this.isLoading.value = false
                    for (car in it) {
                        val latLng = LatLng(car.latitude, car.longitude)
                        mMap.addMarker(MarkerOptions().position(latLng).title(car.name).snippet(car.make))
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f))
                    }
                },
                {
                    this.errorMessage.value = it.message
                    this.isLoading.value = false
                }
            ))
    }

    private fun unwrap(context: Context): AppCompatActivity {
        var context = context
        while (context !is Activity && context is ContextWrapper) {
            context = context.baseContext
        }
        return context as AppCompatActivity
    }
}