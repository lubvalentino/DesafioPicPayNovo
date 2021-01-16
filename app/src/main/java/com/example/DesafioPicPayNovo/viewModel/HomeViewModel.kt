package com.example.DesafioPicPayNovo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.DesafioPicPayNovo.api.ResponseApi
import com.example.DesafioPicPayNovo.model.Users
import com.example.DesafioPicPayNovo.model.home.HomeBusiness
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<Users> = MutableLiveData()
    private val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    private val homeBusiness = HomeBusiness()

    fun getUsers() {
        //criar coroutine scope (cria thread separada) e matar todas as threads secundárias
        viewModelScope.launch {
            when (val response = homeBusiness.getUsers()){
                is ResponseApi.Success -> {
                    usersLiveData.postValue(
                        response.data as? Users
                    )
                }
                is ResponseApi.Error -> {
                    errorMessageLiveData.postValue(
                        response.message
                    )
                }
            }
        }
    }
}