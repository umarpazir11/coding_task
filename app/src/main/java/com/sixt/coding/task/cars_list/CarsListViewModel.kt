package com.sixt.coding.task.cars_list

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import com.sixt.coding.task.R
import com.sixt.coding.task.api.repo.CarsRepository
import com.sixt.coding.task.base.BaseViewModel
import com.sixt.coding.task.di.module.OBSERVER_ON
import com.sixt.coding.task.di.module.SUBCRIBER_ON
import com.sixt.coding.task.model.Car
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class CarsListViewModel @Inject constructor(private val carRepository: CarsRepository,
                                            @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
                                            @param:Named(OBSERVER_ON) private val observerOn: Scheduler) : BaseViewModel() {
    val adapter = MyCarRecyclerViewAdapter()

   // val cars: MutableLiveData<MutableList<Car>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean?> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()


    init {
        this.isLoading.value = true
        getCars()
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
                    //cars.value = it
                    Log.i("cars",""+it.size)
                    //Log.i("cars list",""+ cars.value!!.size)
                    this.isLoading.value = false
                    adapter.updateCarList(it)
                },
                {
                    errorMessage.value = R.string.car_loading_error.toString()
                    this.isLoading.value = false
                }
            ))
    }

}