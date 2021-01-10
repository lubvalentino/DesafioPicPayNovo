package com.example.DesafioPicPayNovo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val users = mutableListOf<User>()

        val user1 = User("teste", "@cesar.rodrigues","Cesar Rodrigues")
        val user2 = User("teste", "@edu.misina","Eduardo Misina")
        val user3 = User("teste", "@vinicius.trapia","Vinicius Trapia")
        val user4 = User("teste", "@jonatas","Jonatas")
        val user5 = User("teste", "@lincoln","Lincoln")

        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        findViewById<RecyclerView>(R.id.rvHomeUserList).apply {
            //como o dado será apresentado
            layoutManager = LinearLayoutManager(this@HomeActivity)
            //colocar a lista
            adapter = MainAdapter(users)
        }
    }
}