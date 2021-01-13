package com.example.DesafioPicPayNovo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DesafioPicPayNovo.model.Users
import com.example.DesafioPicPayNovo.model.home.HomeBusiness

class HomeViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<Users> = MutableLiveData()
    private val homeBusiness = HomeBusiness()

    fun getUsers() {
        val users = homeBusiness.getUsers()
        usersLiveData.postValue(users)
    }
}