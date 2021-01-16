package com.example.DesafioPicPayNovo.model.home

import com.example.DesafioPicPayNovo.api.ApiService
import com.example.DesafioPicPayNovo.api.ResponseApi

//fazer a chamada de API, para não precisar fazer na Business
class HomeRepository {

    suspend fun getUsers(): ResponseApi {
        return try {
            val response = ApiService.picpayApi.users()
            if (response.isSuccessful){
                ResponseApi.Success(response.body())
            }else{
                ResponseApi.Error("Erro ao carregar os dados")
            }
        }catch (exception: Exception){
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }
}