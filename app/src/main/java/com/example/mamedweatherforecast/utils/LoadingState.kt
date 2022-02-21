package com.example.mamedweatherforecast.utils

data class LoadingState private constructor(val status : Status, val msg : String? = null) {

    companion object {

        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)

        fun error(msg: String?) = LoadingState(Status.FAILED)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}