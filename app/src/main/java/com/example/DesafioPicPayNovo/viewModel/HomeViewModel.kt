package com.example.DesafioPicPayNovo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.DesafioPicPayNovo.model.User
import com.example.DesafioPicPayNovo.model.home.HomeBusiness

class HomeViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val homeBusiness = HomeBusiness()

    fun getUsers() {
        usersLiveData.postValue(
                homeBusiness.getUsers()
        )
    }


}