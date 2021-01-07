package com.example.DesafioPicPayNovo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class RegisterCreditCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_credit_card)

        initComponents()
    }

    private fun initComponents() {
        val btnRegisterCreditCard = findViewById<AppCompatButton>(R.id.btnRegisterCreditCard)

        btnRegisterCreditCard.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}