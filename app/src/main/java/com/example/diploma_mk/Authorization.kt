package com.example.diploma_mk

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.os.Handler
import kotlinx.coroutines.NonCancellable.start

class Authorization : AppCompatActivity() {

    lateinit var Email: EditText
    private lateinit var Pass: EditText
    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)


        Email = findViewById(R.id.emailAuthorization)
        Pass = findViewById(R.id.passwordAuthorization)
        auth = FirebaseAuth.getInstance()


        val btn = findViewById<Button>(R.id.btnAuthorization)
        btn.setOnClickListener {
            login()
        }
        val btn1 = findViewById<Button>(R.id.btnBackProlog2)
        btn1.setOnClickListener {
            ClickbtnBackProlog2()
        }
    }

    fun ClickbtnAuthorization() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun ClickbtnBackProlog2() {
        val intent = Intent(this, Prolog2::class.java)
        startActivity(intent)
    }

    private fun login() {
        //get instance of firebase auth
        val firebaseAuth = FirebaseAuth.getInstance()
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        val email = Email.text.toString()
        val pass = Pass.text.toString()
        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Поля не должны быть пустыми", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (firebaseUser?.isEmailVerified() == true) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Вход успешный", Toast.LENGTH_SHORT).show()

                    sp = getSharedPreferences("APP_SETTINGS", Context.MODE_PRIVATE)
                    editor = sp.edit()

                    editor.putBoolean("is_logged", true).commit()

                    val handler = Handler()
                    handler.postDelayed({ ClickbtnAuthorization() }, 1000)
                } else
                    Toast.makeText(this, "Ошибка входа", Toast.LENGTH_SHORT).show()
            }
            if (firebaseUser?.isEmailVerified() != true) {
                Toast.makeText(this, "Подтвердите почту!", Toast.LENGTH_SHORT).show()

            }


        }
    }
}