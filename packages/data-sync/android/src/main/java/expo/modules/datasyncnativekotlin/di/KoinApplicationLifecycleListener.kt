package expo.modules.datasyncnativekotlin.di

import android.app.Application
import expo.modules.core.interfaces.ApplicationLifecycleListener
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.GlobalContext.startKoin


class KoinApplicationLifecycleListener: ApplicationLifecycleListener {
    override fun onCreate(application: Application) {
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(application)
                modules(coreModule)
            }
        }
    }
}