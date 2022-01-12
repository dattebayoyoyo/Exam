
package com.example.hohoho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var editTextName: EditText
    private lateinit var editTextLink: EditText
    private lateinit var buttonChange: Button

    private var auth = FirebaseAuth.getInstance()
    private var db = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(UserInfo::class.java) ?: return

                Glide.with(this@ProfileActivity)
                    .load(userInfo.url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView)

                textView.text = userInfo.name

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
    private fun init(){
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        editTextName = findViewById(R.id.editTextName)
        editTextLink = findViewById(R.id.editTextLink)
        buttonChange = findViewById(R.id.buttonChange)
    }
    private fun registerListeners(){
        buttonChange.setOnClickListener {
            val personname = editTextName.text.toString()
            val url = editTextLink.text.toString()

            val userInfo = UserInfo(personname, url)

            db.child(auth.currentUser?.uid!!).setValue(userInfo)
        }

    }
}
