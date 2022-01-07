package com.example.hohoho

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class Fragment2 : Fragment(R.layout.activity_fragment2) {

        private lateinit var name: TextView
        private lateinit var uid: TextView
        private lateinit var logOutButton: Button
        private lateinit var ChangePassButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.name)
        uid = view.findViewById(R.id.uid)
        logOutButton = view.findViewById(R.id.logOutButton)
        ChangePassButton = view.findViewById(R.id.ChangePassButton)

        name.text = FirebaseAuth.getInstance().currentUser?.email
        uid.text = FirebaseAuth.getInstance().currentUser?.uid

        logout()
        changePass()
    }

    private fun logout() {
        logOutButton.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
    private fun changePass(){
        ChangePassButton.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, PasswordChangeActivity::class.java))
                finish()
            }
        }
    }

}

