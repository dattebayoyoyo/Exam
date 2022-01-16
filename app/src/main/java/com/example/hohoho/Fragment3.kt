package com.example.hohoho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class Fragment3 : Fragment(R.layout.activity_fragment3) {
    private  lateinit var  insertButton: Button
    private lateinit var buyButton: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertButton = view.findViewById(R.id.insertButton)
        buyButton = view.findViewById(R.id.buyButton)
        insert()
        buttonclick()
    }
    private fun insert(){
        insertButton.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()

            }
        }

    }
    private fun buttonclick() {
        buyButton.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, PayActivity::class.java))
                finish()
            }
        }
    }

}