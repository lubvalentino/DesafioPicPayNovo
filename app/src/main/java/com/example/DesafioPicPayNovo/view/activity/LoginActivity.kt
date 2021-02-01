package com.example.DesafioPicPayNovo.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.DesafioPicPayNovo.databinding.ActivityLoginBinding
import com.facebook.CallbackManager
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    private val RC_SIGN_IN = 999

    private val firebaseAuth by lazy {
        Firebase.auth
    }

    private val callbackManager by lazy {
        CallbackManager.Factory.create()
    }

    private val providers by lazy {
        arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build(),
                AuthUI.IdpConfig.FacebookBuilder().build(),
                AuthUI.IdpConfig.AnonymousBuilder().build()
        )}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        signUp()

//        //Login com Facebook
//        LoginManager.getInstance().registerCallback(callbackManager,
//            object : FacebookCallback<LoginResult?> {
//                override fun onSuccess(loginResult: LoginResult?) {
//                    val token = loginResult?.accessToken
//                    val facebookCredential = FacebookAuthProvider.getCredential(token?.token ?: "")
//                    firebaseAuth.signInWithCredential(facebookCredential)
//                        .addOnSuccessListener {
//                            binding.tvLoginUserName.text = it.user?.displayName
//                        }.addOnFailureListener {
//                            Log.i("teste", it.toString())
//                            when(it) {
//                                is FirebaseAuthWeakPasswordException -> {
//                                    Toast.makeText(this@MainActivity, "Senha fraca", Toast.LENGTH_SHORT).show()
//                                }
//                                is FirebaseAuthUserCollisionException -> {
//                                    Toast.makeText(this@MainActivity, "Esse usuário já existe", Toast.LENGTH_SHORT).show()
//                                }
//                                else -> {
//                                    Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                        }
//                }
//
//                override fun onCancel() {
//                    Log.i("teste", "teste")
//                }
//
//                override fun onError(exception: FacebookException) {
//                    exception
//                }
//            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = firebaseAuth.currentUser
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    private fun signUp() {
        //ação ao clicar no botão - login com email e senha
        binding.btLoginSignUpEmail.setOnClickListener {
            //criar o usuário pelo email
            firebaseAuth.createUserWithEmailAndPassword("teste@teste.com.br", "123456")
                    //quando for sucesso no login
                    .addOnSuccessListener {
                        binding.tvLoginUserName.text = it.user?.displayName
                        //quando der falha no login
                    }.addOnFailureListener {
                        when (it){
                            //exception senha fraca
                            is FirebaseAuthWeakPasswordException ->{
                                Toast.makeText(this, "Senha fraca", Toast.LENGTH_LONG).show()
                            }
                            else ->{
                                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
        }

        //ação ao clicar o botão - login anônimo
        binding.btLoginSignUpAnonymous.setOnClickListener {
            firebaseAuth.signInAnonymously().addOnSuccessListener {
                binding.tvLoginUserName.text = "Usuário anônimo"
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        //verificar se tem usuário logado
        firebaseAuth.currentUser?.let {
            binding.tvLoginUserName.text = it.displayName
        } ?: run {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN)
        }
    }
}