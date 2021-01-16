package com.example.DesafioPicPayNovo.api

import com.example.DesafioPicPayNovo.utils.Constants.API.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    //vai criar os end points que vai acessar
    //a interface busca o end point e na função create eu chamo ela pra continuar minha url
    val picpayApi = getPicpayApiClient().create(PicpayApi::class.java)

    // vai ser responsável por todas as chamadas de api
    private fun getPicpayApiClient():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
                //transformar o JSON em um objeto, neste caso Users, usando GSON
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}