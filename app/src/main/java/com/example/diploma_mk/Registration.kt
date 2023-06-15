package com.example.diploma_mk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Registration : AppCompatActivity() {

    lateinit var Email: EditText
    lateinit var ConfPass: EditText
    private lateinit var Pass: EditText
    lateinit var firstname: EditText


    private lateinit var auth: FirebaseAuth
    var databaseReference1: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val btn = findViewById<Button>(R.id.btnRegistration)
        btn.setOnClickListener {
            signUpUser()
        }
        val btn1 = findViewById<Button>(R.id.btnBackProlog2)
        btn1.setOnClickListener {
            ClickBackRegistration()
        }


        firstname = findViewById(R.id.nameRegistration)
        Email = findViewById(R.id.emailRegistration)
        Pass = findViewById(R.id.passwordRegistration)
        ConfPass = findViewById(R.id.repeatPasswordRegistration)

        auth = Firebase.auth
        databaseRef = FirebaseDatabase.getInstance().getReference()
        database = FirebaseDatabase.getInstance()
        databaseReference1 = database?.reference!!.child("Profile")
    }


    fun ClickBackRegistration() {
        val intent = Intent(this, Prolog2::class.java)
        startActivity(intent)
    }
    private fun sendEmailVerification() {
        //get instance of firebase auth
        val firebaseAuth = FirebaseAuth.getInstance()
        //get current user
        val firebaseUser = firebaseAuth.currentUser

        //send email verification
        firebaseUser!!.sendEmailVerification()
            .addOnSuccessListener {
                Toast.makeText(this, "Ссылка для подтверждения отправлена на почту", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to send due to " + e.message, Toast.LENGTH_SHORT).show()
            }


    }
    private fun signUpUser() {
        val firstName = firstname.text.toString()
        val email = Email.text.toString()
        val pass = Pass.text.toString()
        val confirmPassword = ConfPass.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank() || firstName.isBlank() ) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmPassword) {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener() {
            if (it.isSuccessful) {
                sendEmailVerification()
                val currentUser = auth.currentUser
                val currentUSerDB1 = databaseReference1?.child(currentUser?.uid!!)
                currentUSerDB1?.child("email")?.setValue(email)
                currentUSerDB1?.child("password")?.setValue(pass)
                currentUSerDB1?.child("firstname")?.setValue(firstname.text.toString())
                val intent = Intent(this, Authorization::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Ошибка регистрации!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}