package com.example.hohoho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextOldPassword: EditText
    private lateinit var editTextNewPassword: EditText
    private lateinit var buttonChange: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        init()
        registerListeners()
    }
    private fun init(){
        editTextOldPassword = findViewById(R.id.editTextOldPassword)
        editTextNewPassword = findViewById(R.id.editTextNewPassword)

        buttonChange = findViewById(R.id.buttonChange)
    }
    private fun registerListeners(){
        buttonChange.setOnClickListener {
            val newPassword = editTextNewPassword.text.toString()

            if (newPassword.isEmpty() || newPassword.length < 5 || editTextOldPassword.text==editTextNewPassword.text){
                Toast.makeText(this, "incorrect password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    gotoProfile()

                }else{
                    Toast.makeText(this, " error", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }
    private fun gotoProfile(){
        startActivity(Intent(this, Fragment1::class.java))
        finish()}
}