package com.example.DesafioPicPayNovo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.DesafioPicPayNovo.R
import com.example.DesafioPicPayNovo.model.UsersItem
import com.example.DesafioPicPayNovo.view.activity.HomeActivity.Companion.KEY_INTENT_USER

class UserPaymentActivity : AppCompatActivity() {

    private var user: UsersItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_payment)

        user = intent.getParcelableExtra(KEY_INTENT_USER)

        setUpUser()
    }

    private fun setUpUser() {
//        Glide.with(this).load(user?.img).into(findViewById<CircleImageView>(R.id.ivUserPaymentAvatar))
//        findViewById<TextView>(R.id.tvUserPaymentUserId).text = user?.username
    }
}