package com.example.mamedweatherforecast.app.di

import android.app.Application
import androidx.room.Room
import com.example.mamedweatherforecast.model.AppDatabase
import com.example.mamedweatherforecast.model.api.WeatherTownApi
import com.example.mamedweatherforecast.model.dao.WeatherTownDao
import com.example.mamedweatherforecast.model.repository.WeatherTownRepository
import com.example.mamedweatherforecast.viewmodel.TownViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import org.koin.android.ext.koin.androidApplication

val viewModelModule = module {

    single { TownViewModel(get()) }
}

val apiModule = module {

    fun provideWeatherTownApi(retrofit : Retrofit) : WeatherTownApi {
        return retrofit.create(WeatherTownApi::class.java)
    }

    single { provideWeatherTownApi(get()) }
}

val netModule = module {

    fun provideRetrofit(factory : Gson, client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    fun provideCache(application :  Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache : Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideGson() : Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    single { provideRetrofit(get(), get()) }
    single { provideCache(androidApplication()) }
    single { provideGson() }
    single { provideHttpClient(get()) }
}

val databaseModule = module {

    fun provideDatabase(application : Application) : AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: AppDatabase) : WeatherTownDao {
        return database.weatherTownDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {

    fun provideWeatherTownRepository(weatherTownApi : WeatherTownApi, weatherTownDao : WeatherTownDao) : WeatherTownRepository {
        return WeatherTownRepository(weatherTownApi, weatherTownDao)
    }

    single { provideWeatherTownRepository(get(), get()) }
}

