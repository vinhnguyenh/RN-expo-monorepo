package expo.modules.datasyncnativekotlin.di

import expo.modules.datasyncnativekotlin.core.network.AndroidNetworkMonitor
import expo.modules.datasyncnativekotlin.core.network.NetworkMonitor
import expo.modules.datasyncnativekotlin.di.provider.provideOkHttpClient
import expo.modules.datasyncnativekotlin.di.provider.provideRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val coreModule = module {
    single<NetworkMonitor> { AndroidNetworkMonitor(androidContext()) }
    // 2. Network
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}