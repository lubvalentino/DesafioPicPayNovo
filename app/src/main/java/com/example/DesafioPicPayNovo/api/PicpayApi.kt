package com.example.DesafioPicPayNovo.api

import com.example.DesafioPicPayNovo.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface PicpayApi {
    //@get que diz o end point que eu vou acessar, ou seja qual o método http
    //value = exatamente a continuação da url que queremos => end point
    @GET ("users")
    //suspend é o que diz pra esse método ser executado em uma thread separada
    suspend fun users():Response<Users>
}