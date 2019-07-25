package com.sixt.coding.task.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sixt.coding.task.cars_list.CarsListViewModel
import com.sixt.coding.task.cars_map.MapViewModel
import com.sixt.coding.task.di.ViewModelKey
import com.sixt.coding.task.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun mapViewModel(viewModel: MapViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CarsListViewModel::class)
    abstract fun carsListViewModel(viewModel: CarsListViewModel): ViewModel
}

