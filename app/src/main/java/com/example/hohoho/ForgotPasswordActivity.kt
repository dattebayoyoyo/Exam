package com.example.hohoho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSend: Button
    var dog = "@"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
        registerListeners()
    }
    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSend = findViewById(R.id.buttonSend)
    }
    private fun registerListeners(){
        buttonSend.setOnClickListener {
            val email = editTextEmail.text.toString()
            if(email.isEmpty() || dog.isEmpty() || dog.length>1){
                Toast.makeText(this,"Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "check email", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()


                    }
                }
        }


    }
}