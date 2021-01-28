package com.example.DesafioPicPayNovo.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.DesafioPicPayNovo.databinding.ActivityLoginBinding
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 2

    private val callbackManager by lazy {
        CallbackManager.Factory.create()
    }
//    233954094979-mglag716nqvp8aq8iu8vvo079sbtcf4t.apps.googleusercontent.com
//    uDqR8970_m4MI4rA1SP8GZ02

    private lateinit var binding: ActivityLoginBinding

    private lateinit var signInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        login google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        binding.signInButton.setOnClickListener {
            val signInIntent: Intent = signInClient.getSignInIntent()
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        signInClient = GoogleSignIn.getClient(this, gso)

//       login facebook
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired

        if (isLoggedIn){
            binding.loginButton.isVisible = false
        } else{
            binding.loginButton.setPermissions("email")
        }

        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult?> {
                override fun onSuccess(result: LoginResult?) {
                    val request = GraphRequest.newMeRequest(
                        result?.accessToken
                    ) { jsonResponse, response ->
                        jsonResponse
                        response
                    }
                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,link,email")
                    request.parameters = parameters
                    request.executeAsync()
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(error: FacebookException?) {
                    error
                }
            })
    }

    override fun onResume() {
        super.onResume()
        val account = GoogleSignIn.getLastSignedInAccount(this)

        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired

        if (isLoggedIn){
            binding.loginButton.isVisible = false
        } else{
            binding.loginButton.setPermissions("email")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN){
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            binding.signInButton.isVisible = false
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.statusCode)
        }
    }
}