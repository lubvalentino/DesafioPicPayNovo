package com.example.DesafioPicPayNovo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {
    private lateinit var btBottomSheet : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        btBottomSheet = findViewById(R.id.btBottomSheet)

        btBottomSheet.setOnClickListener {
            val bottomSheet = PaymentFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

    }

}