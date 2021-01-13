package com.example.DesafioPicPayNovo.model.home

import com.example.DesafioPicPayNovo.model.Users

class HomeBusiness {

    private val repository : HomeRepository by lazy {
        HomeRepository()
    }

    fun getUsers(): Users{

        val users = repository.getUsers()
        return users
    }
}