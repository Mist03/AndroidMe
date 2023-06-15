
package com.example.diploma_mk.Fragment


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diploma_mk.Prolog2
import com.example.diploma_mk.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.io.File
import java.io.FileOutputStream


class ProfileFragment : Fragment() {
    lateinit var databaseRef: DatabaseReference
    lateinit var textView1: TextView
    var t1 =""
    private lateinit var avatarImageView: ImageView
    private lateinit var chooseImageButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        avatarImageView = view.findViewById(R.id.avatar_image_view)
        chooseImageButton = view.findViewById(R.id.choose_image_button)
        chooseImageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_IMAGE_PICK)
        }

// Load the user's avatar from SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val avatarPath = sharedPreferences.getString("avatarPath", null)
        if (avatarPath != null) {
            val file = File(avatarPath)
            if (file.exists()) {
                val uri = Uri.fromFile(file)
                avatarImageView.setImageURI(uri)
            }
        }

        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            if (imageUri != null) {
                avatarImageView.setImageURI(imageUri)

                val inputStream = requireActivity().contentResolver.openInputStream(imageUri)
                val file = File(requireActivity().filesDir, "avatar.jpg")
                val outputStream = FileOutputStream(file)

                inputStream?.copyTo(outputStream)

// Save the image as the user's avatar
                val editor =
                    requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit()
                editor.putString("avatarPath", file.absolutePath)
                editor.apply()
            }
        }

    }
    companion object {
        private const val REQUEST_IMAGE_PICK = 1
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = FirebaseAuth.getInstance().getCurrentUser()?.getUid()
        textView1 = view.findViewById(R.id.textView7)
        databaseRef = FirebaseDatabase.getInstance().getReference()
        databaseRef.child("Profile/${currentUser}/firstname").addValueEventListener(object :
            ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                textView1.text = ("${snapshot.value}")
                t1 = ("${snapshot.value}")
                if(t1 == "null"){
                    val intent = Intent(view.context, Prolog2::class.java)
                    intent.putExtra("Exit", "1")
                    startActivity(intent)
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        val btn = view.findViewById<Button>(R.id.btnExitAccount)
        btn.setOnClickListener {
            val editor =
                requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    .edit()
            editor.remove("avatarPath")
            editor.apply()
            val intent = Intent(view.context, Prolog2::class.java)
            intent.putExtra("Exit", "1")
            startActivity(intent)
        }
    }

}