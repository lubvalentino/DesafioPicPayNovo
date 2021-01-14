package com.example.DesafioPicPayNovo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.DesafioPicPayNovo.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
        setUpObservables()

    }

    private fun setUpObservables() {
        //verificar o que foi checado na tela
        binding.scTeste1.setOnCheckedChangeListener { _, isChecked ->
            //acessar ou criar o arquivo de preferências => .edit{} para editar o arquivo
            getSharedPreferences("picpay", MODE_PRIVATE).edit {
                //salvar
                putBoolean("dark_mode", isChecked)
            }
        }

        binding.scTeste2.setOnCheckedChangeListener { _, isChecked ->
            //acessar ou criar o arquivo de preferências => .edit{} para editar o arquivo
            getSharedPreferences("picpay", MODE_PRIVATE).edit {
                putBoolean("teste1", isChecked)
            }
        }

        binding.scTeste3.setOnCheckedChangeListener { _, isChecked ->
            //acessar ou criar o arquivo de preferências => .edit{} para editar o arquivo
            getSharedPreferences("picpay", MODE_PRIVATE).edit {
                putBoolean("teste2", isChecked)
            }
        }
    }

    private fun initComponents() {
        //ler o dado
        val darkMode = getSharedPreferences("picpay", MODE_PRIVATE).getBoolean("dark_mode", false)
        val teste1 = getSharedPreferences("picpay", MODE_PRIVATE).getBoolean("teste1", false)
        val teste2 = getSharedPreferences("picpay", MODE_PRIVATE).getBoolean("teste2", false)


        //marcar o que está checado pelo usuário
        binding.scTeste1.isChecked = darkMode
        binding.scTeste2.isChecked = teste1
        binding.scTeste3.isChecked = teste2

    }
}