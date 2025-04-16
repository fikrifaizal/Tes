package com.nextgen.tes.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.nextgen.tes.R
import com.nextgen.tes.databinding.ActivityLoginBinding
import com.nextgen.tes.ui.main.MainActivity
import com.nextgen.tes.ui.main.MainActivity.Companion.EXTRA_TOKEN
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            loginHandler()
        }

//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    private fun loginHandler() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        lifecycleScope.launch {
            loginViewModel.getUserLogin(username, password).collect { result ->
                result.onSuccess {
                    it.data.accessToken.let { token ->
                        loginViewModel.saveToken(token)

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra(EXTRA_TOKEN, token)
                        startActivity(intent)
                        finish()
                    }
                }
                result.onFailure {
                    it.printStackTrace()
                    Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}