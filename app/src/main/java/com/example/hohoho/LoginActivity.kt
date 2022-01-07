package com.example.hohoho

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.recycleview.main
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonlogin: Button
    private lateinit var buttonregistration: Button
    private lateinit var forgotPassword: TextView
    var dog ="@"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /// if(FirebaseAuth.getInstance().currentUser !=null){ gotoProfile() }


        setContentView(R.layout.login_main)

        init()
        registerListeners()
    }
    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonlogin = findViewById(R.id.buttonlogin)
        buttonregistration = findViewById(R.id.buttonregistration)
        forgotPassword = findViewById(R.id.forgotPassword)

    }
    private fun registerListeners(){
        buttonregistration.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        buttonlogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() || dog.isEmpty() || dog.length > 1){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        gotoProfile()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun gotoProfile(){
        startActivity(Intent(this, main::class.java))
        finish()
    }
}