package com.example.DesafioPicPayNovo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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

        findViewById<RecyclerView>(R.id.rvHomeUserList).apply {
            //como o dado será apresentado
            layoutManager = LinearLayoutManager(this@HomeActivity)
            //colocar a lista
            adapter = MainAdapter(users) {position ->
                val intent = Intent(this@HomeActivity, UserPaymentActivity::class.java)
                intent.putExtra(KEY_INTENT_USER, users[position])
                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_INTENT_USER = "users"
    }
}