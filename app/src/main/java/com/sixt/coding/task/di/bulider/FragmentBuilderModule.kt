package com.sixt.coding.task.di.bulider


import com.sixt.coding.task.cars_list.CarFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun carFragment(): CarFragment




}
