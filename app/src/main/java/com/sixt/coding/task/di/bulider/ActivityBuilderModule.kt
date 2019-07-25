package com.sixt.coding.task.di.bulider


import com.sixt.coding.task.MapsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * The module which provides the android injection service to Activities.
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun mapsActivity(): MapsActivity



}
