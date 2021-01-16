package com.example.DesafioPicPayNovo.api

//classe selada = classe abstrata com super poderes
//testar se da sucesso ou erro de uma forma genérica
sealed class ResponseApi {
    class Success(val data:Any?) : ResponseApi()
    class Error (val message: String) : ResponseApi()
}