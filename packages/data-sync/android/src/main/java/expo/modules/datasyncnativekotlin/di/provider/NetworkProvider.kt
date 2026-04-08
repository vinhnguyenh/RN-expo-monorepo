package expo.modules.datasyncnativekotlin.di.provider

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import expo.modules.datasyncnativekotlin.sdk.api.DataSyncConfig
import expo.modules.datasyncnativekotlin.sdk.data.mapper.AppJson
import expo.modules.datasyncnativekotlin.sdk.platform.android.network.NetworkClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

fun provideOkHttpClient(config: DataSyncConfig): OkHttpClient {
    val builder = Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)

    if (config.enableLogging) {
        builder.addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
    }

    return builder.build()
}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    config: DataSyncConfig
): Retrofit =
    Retrofit
        .Builder()
        .baseUrl(config.baseUrl ?: NetworkClient.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(AppJson.instance.asConverterFactory("application/json".toMediaType()))
        .build()
