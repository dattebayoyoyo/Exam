package com.example.hohoho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recycleview.main

class PayActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var number: EditText
    private lateinit var cvv: EditText
    private lateinit var Tanxa: EditText
    private lateinit var saxeli: EditText
    private lateinit var gadaricxva: Button
    private lateinit var misamarti: EditText
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay)
        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        cvv = findViewById(R.id.cvv)
        Tanxa = findViewById(R.id.Tanxa)
        saxeli = findViewById(R.id.saxeli)
        gadaricxva = findViewById(R.id.gadaricxva)
        misamarti = findViewById(R.id.misamarti)
        back = findViewById(R.id.back)
        pay()
        back()
    }
    private fun pay() {
        gadaricxva.setOnClickListener {
            if (name.text.isEmpty() || name.text.length < 2 || number.text.isEmpty() || number.text.length != 16 || cvv.text.isEmpty() || cvv.text.length != 3 || Tanxa.text.isEmpty() ||
                saxeli.text.isEmpty() || saxeli.text.length < 3 || misamarti.text.isEmpty() || misamarti.text.length < 5
            ) {
                Toast.makeText(this, "მონაცემები შეყვანილია არასწორად!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "თანხა გადარიცხულია", Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun back(){
        back.setOnClickListener{
            val intent = Intent(this, main::class.java)
            startActivity(intent)
        }
    }
}