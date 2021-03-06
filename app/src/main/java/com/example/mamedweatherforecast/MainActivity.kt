package com.example.mamedweatherforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mamedweatherforecast.model.entity.WeatherTown
import com.example.mamedweatherforecast.utils.LoadingState
import com.example.mamedweatherforecast.viewmodel.TownViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val townViewModel by viewModel<TownViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        townViewModel.data.observe(this, Observer {
            Log.e("TAG", it.name)
        })

        townViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED ->   Log.e("TAG", it.msg.toString())
                LoadingState.Status.RUNNING -> Toast.makeText(
                    baseContext,
                    "Loading",
                    Toast.LENGTH_SHORT
                ).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(
                    baseContext,
                    "Success",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}