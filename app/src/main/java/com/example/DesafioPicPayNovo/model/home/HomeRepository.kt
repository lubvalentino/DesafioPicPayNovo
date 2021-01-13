package com.example.DesafioPicPayNovo.model.home

import com.example.DesafioPicPayNovo.model.User
import com.example.DesafioPicPayNovo.model.Users

//fazer a chamada de API, para não precisar fazer na Business
class HomeRepository {

    fun getUsers(): Users {

        val user1 = User(1001,"https://randomuser.me/api/portraits/lego/6.jpg","Cesar Rodrigues","@cesar.rodrigues")
        val user2 = User(1002,"https://randomuser.me/api/portraits/lego/8.jpg", "Eduardo Misina","@edu.misina")
        val user3 = User(1003,"https://randomuser.me/api/portraits/lego/5.jpg", "Vinicius Trapia","@vinicius.trapia")
        val user4 = User(1004,"https://randomuser.me/api/portraits/lego/4.jpg", "Jonatas","@jonatas")
        val user5 = User(1005,"https://randomuser.me/api/portraits/lego/2.jpg", "Lincoln","@lincoln")

        return Users(listOf(user1,user2,user3,user4,user5))
    }
}