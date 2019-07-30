package com.sixt.coding.task.base

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.sixt.coding.task.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class BaseApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

        private var sInstance: BaseApplication? = null

    fun getAppContext(): BaseApplication? {
        return sInstance
    }
    @Synchronized
    private fun setInstance(app: BaseApplication) {
        sInstance = app
    }

    override fun onCreate() {
        super.onCreate()
         DaggerAppComponent.builder()
                .application(this)
                .build().inject(this)
        setInstance(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

}