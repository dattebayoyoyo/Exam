
package com.example.hohoho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.insertphotoactivity.FlowersInfo
import com.example.recycleview.main
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
    private lateinit var buttonBack: Button

    private var auth = FirebaseAuth.getInstance()
    private var db = FirebaseDatabase.getInstance().getReference("FlowersInfo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerFlowers()
        back()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val flowersInfo = snapshot.getValue(FlowersInfo::class.java) ?: return

                Glide.with(this@ProfileActivity)
                    .load(flowersInfo.url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView)

                textView.text = flowersInfo.name

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
        buttonBack = findViewById(R.id.buttonBack)
    }
    private fun registerFlowers(){
        buttonChange.setOnClickListener {
            val name = editTextName.text.toString()
            val url = editTextLink.text.toString()

            val flowersInfo = FlowersInfo(name, url)

            db.child(auth.currentUser?.uid!!).setValue(flowersInfo)
        }

    }
    private fun back(){
        buttonBack.setOnClickListener{
            val intent = Intent(this, main::class.java)
            startActivity(intent)
        }
    }
}
