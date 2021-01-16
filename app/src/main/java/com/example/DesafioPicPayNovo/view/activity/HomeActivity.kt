package com.example.DesafioPicPayNovo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.DesafioPicPayNovo.R
import com.example.DesafioPicPayNovo.view.adapter.MainAdapter
import com.example.DesafioPicPayNovo.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvHomeUserList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getUsers()

        setUpObservebles()
    }

    private fun setUpObservebles() {
        viewModel.usersLiveData.observe(this, {
            it?.let {users ->
                recyclerView.apply {
                    //como o dado será apresentado
                    layoutManager = LinearLayoutManager(this@HomeActivity)
                    //colocar a lista
                    adapter = MainAdapter(users) {position ->
//                        val intent = Intent(this@HomeActivity, UserPaymentActivity::class.java)
//                        intent.putExtra(KEY_INTENT_USER, users.usersList[position])
//                        startActivity(intent)
                }
            }
        }})
    }

    companion object {
        const val KEY_INTENT_USER = "users"
    }
}