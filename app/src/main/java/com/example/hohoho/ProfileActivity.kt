package com.example.hohoho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var buttonLogOut: Button
    private lateinit var buttonPasswordChange: Button
    private lateinit var textView: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()

        textView2.text = FirebaseAuth.getInstance().currentUser?.uid
        textView.text = FirebaseAuth.getInstance().currentUser?.email


    }
    private fun init(){
        buttonLogOut = findViewById(R.id.buttonLogOut)
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)


    }
    private fun registerListeners(){
        buttonLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        buttonPasswordChange.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
            finish()
        }
    }

}