package com.example.DesafioPicPayNovo.view.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.DesafioPicPayNovo.R
import com.example.DesafioPicPayNovo.view.fragment.PaymentFragment
import com.example.DesafioPicPayNovo.viewModel.PaymentViewModel

class PaymentActivity : AppCompatActivity() {

    private lateinit var viewModel : PaymentViewModel
    private lateinit var btBottomSheet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        viewModel = ViewModelProvider(this).get(PaymentViewModel::class.java)

        btBottomSheet = findViewById(R.id.btBottomSheet)

        btBottomSheet.setOnClickListener {
            val bottomSheet = PaymentFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

    }

}