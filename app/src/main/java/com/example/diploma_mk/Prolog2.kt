package com.example.diploma_mk

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Prolog2 : AppCompatActivity() {
    lateinit var sp : SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prolog2)

        sp = getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE)
        editor = sp.edit()
        val b = intent.getStringExtra("Exit")
        if (b=="1") {
            editor.remove("is_logged").commit()
        }

        val btn = findViewById<Button>(R.id.buttonRegistrationProlog2)
        btn.setOnClickListener {
            ClickPrologRegistration()
        }
        val btn1 = findViewById<Button>(R.id.buttonAutorizationProlog2)
        btn1.setOnClickListener {
            ClickPrologAutorization()
        }
    }

    fun ClickPrologRegistration() {
        val intent = Intent(this, Registration::class.java)
        startActivity(intent)
    }

    fun ClickPrologAutorization() {
        val intent = Intent(this, Authorization::class.java)
        startActivity(intent)
    }
}