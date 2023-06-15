package com.example.diploma_mk.Topic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diploma_mk.*

class DesignTopic : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView


    lateinit var image1: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView
    lateinit var image4: ImageView


    var text1 = ""
    var text2 = ""
    var text3 = ""
    var text4 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_topic)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView5)


        image1 = findViewById(R.id.imageView4)
        image2 = findViewById(R.id.imageView6)
        image3 = findViewById(R.id.imageView7)
        image4 = findViewById(R.id.imageView8)



        if (baf == 1) {
            text1 = topicDesign_1_1
            image1.setImageDrawable(getDrawable(R.drawable.design1))
            text2 = topicDesign_1_2
        } else if (baf == 2) {
            text1 = topicDesign_2_1
            image1.setImageDrawable(getDrawable(R.drawable.design2))
            text2 = topicDesign_2_2
            image2.setImageDrawable(getDrawable(R.drawable.design3))
            text3 = topicDesign_2_3
            image3.setImageDrawable(getDrawable(R.drawable.design4))
            text4 = topicDesign_2_4


        } else if (baf == 3) {
            text1 = topicDesign_3_1
            image1.setImageDrawable(getDrawable(R.drawable.design5))
            text2 = topicDesign_3_2
            image2.setImageDrawable(getDrawable(R.drawable.design6))

        }

        textView1.text = (Html.fromHtml(text1))
        textView2.text = (Html.fromHtml(text2))
        textView3.text = (Html.fromHtml(text3))
        textView4.text = (Html.fromHtml(text4))


        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
    }
}