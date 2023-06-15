package com.example.diploma_mk.Topic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diploma_mk.*

class KotlinTopic : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var image1: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView
    lateinit var image4: ImageView
    var text1 = ""
    var text2 = ""
    var text3 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_topic)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        image1 = findViewById(R.id.imageView4)
        image2 = findViewById(R.id.imageView6)
        image3 = findViewById(R.id.imageView7)
        image4 = findViewById(R.id.imageView8)

        if (baf == 1) {
            text1 = topicKotlin_1_1
            image1.setImageDrawable(getDrawable(R.drawable.kotl))
            text2 = topicKotlin_1_2
            image2.setImageDrawable(getDrawable(R.drawable.andr))
            text3 = topicKotlin_1_3
        } else if (baf == 2) {
            text1 = topicKotlin_2_1
            image1.setImageDrawable(getDrawable(R.drawable.prog1))
            text2 = topicKotlin_2_2
            image2.setImageDrawable(getDrawable(R.drawable.prog2))
            text3 = topicKotlin_3_3
        } else if (baf == 3) {
            text1 = topicKotlin_3_1
            image1.setImageDrawable(getDrawable(R.drawable.class1))
            text2 = topicKotlin_3_2
            image2.setImageDrawable(getDrawable(R.drawable.class2))
            text3 = topicKotlin_3_3
        }

        textView1.text = (Html.fromHtml(text1))
        textView2.text = (Html.fromHtml(text2))
        textView3.text = (Html.fromHtml(text3))

        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }

    }
}