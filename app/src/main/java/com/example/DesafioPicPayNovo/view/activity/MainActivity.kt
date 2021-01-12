package com.example.DesafioPicPayNovo.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.DesafioPicPayNovo.R
import com.example.DesafioPicPayNovo.extensions.setErrorIfEmpty
import com.example.DesafioPicPayNovo.utils.MaskWatcher
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    private lateinit var etCreditcardName : EditText
    private lateinit var etCreditCardNumber: EditText
    private lateinit var etCreditCardExpiration: EditText
    private lateinit var tilCreditCardExpiration: TextInputLayout
    private lateinit var etCreditCardCvv: EditText
    private lateinit var btCreditCardSave: Button
    private lateinit var btBack : ImageButton

    private fun canEnableSaveButton():Boolean{
        return etCreditCardNumber.length() > 0 && etCreditcardName.length() > 0
                && etCreditCardExpiration.length() > 0 && etCreditCardCvv.length() > 0
    }

    private fun initValidators(){
        etCreditCardNumber.setErrorIfEmpty(getString(R.string.error_mensage_credit_card_number))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCreditcardName = findViewById(R.id.etCreditCardName)
        etCreditCardNumber = findViewById(R.id.etCreditCardNumber)
        etCreditCardExpiration = findViewById(R.id.etCreditCardExpiration)
        etCreditCardCvv = findViewById(R.id.etCreditCardCvv)
        btCreditCardSave = findViewById(R.id.btCreditCardSave)
        btBack = findViewById(R.id.ibRegisterCard)
        tilCreditCardExpiration = findViewById(R.id.tilCreditCardExpiration)
        etCreditCardNumber.addTextChangedListener(MaskWatcher(etCreditCardNumber,getString(R.string.credit_card_mask)))
        etCreditCardExpiration.addTextChangedListener(MaskWatcher(etCreditCardExpiration,getString(R.string.expiration_mask)))
        etCreditCardCvv.addTextChangedListener(MaskWatcher(etCreditCardCvv,getString(R.string.cvv_mask)))

        

        btCreditCardSave.setOnClickListener {
//            val expirationDate = etCreditCardExpiration.text.toString()
//            val monthYear = expirationDate.split("/")
//            if (monthYear.first().toInt() > 12) {
//                tilCreditCardExpiration.error = "Data de expiração inválida"
//            }else{
//                tilCreditCardExpiration.isErrorEnabled = false
//            }
            startActivity(Intent(this, PaymentActivity::class.java))
        }

        btBack.setOnClickListener {
            finish()
        }
    }
}