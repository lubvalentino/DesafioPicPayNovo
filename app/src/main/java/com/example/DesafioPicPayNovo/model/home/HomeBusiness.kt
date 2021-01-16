package com.example.DesafioPicPayNovo.model.home

import com.example.DesafioPicPayNovo.api.ResponseApi

class HomeBusiness {

    private val repository : HomeRepository by lazy {
        HomeRepository()
    }

    suspend fun getUsers(): ResponseApi {
        return repository.getUsers()

    }
}