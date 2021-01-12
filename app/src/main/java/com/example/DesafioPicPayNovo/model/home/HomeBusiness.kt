package com.example.DesafioPicPayNovo.model.home

import com.example.DesafioPicPayNovo.model.User

class HomeBusiness {

    fun getUsers(): List<User>{
        val users = mutableListOf<User>()

        val user1 = User("https://randomuser.me/api/portraits/lego/6.jpg", "@cesar.rodrigues","Cesar Rodrigues")
        val user2 = User("https://randomuser.me/api/portraits/lego/8.jpg", "@edu.misina","Eduardo Misina")
        val user3 = User("https://randomuser.me/api/portraits/lego/5.jpg", "@vinicius.trapia","Vinicius Trapia")
        val user4 = User("https://randomuser.me/api/portraits/lego/4.jpg", "@jonatas","Jonatas")
        val user5 = User("https://randomuser.me/api/portraits/lego/2.jpg", "@lincoln","Lincoln")

        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        return users
    }
}