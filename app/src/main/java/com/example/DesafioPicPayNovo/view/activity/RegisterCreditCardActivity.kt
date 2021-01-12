package com.example.DesafioPicPayNovo.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.DesafioPicPayNovo.R

class RegisterCreditCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_credit_card)

        initComponents()
    }

    private fun initComponents() {
        val btnRegisterCreditCard = findViewById<AppCompatButton>(R.id.btnRegisterCreditCard)
        val btnBack = findViewById<ImageButton>(R.id.ibRegisterCreditCard)

        btnRegisterCreditCard.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnBack.setOnClickListener{
            finish()
        }


    }


}