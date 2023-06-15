package com.example.diploma_mk.Topic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diploma_mk.*

class AndroidTopic : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView
    lateinit var textView7: TextView
    lateinit var textView8: TextView
    lateinit var textView9: TextView

    lateinit var image1: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView
    lateinit var image4: ImageView
    lateinit var image5: ImageView
    lateinit var image6: ImageView
    lateinit var image7: ImageView
    lateinit var image8: ImageView

    var text1 = ""
    var text2 = ""
    var text3 = ""
    var text4 = ""
    var text5 = ""
    var text6 = ""
    var text7 = ""
    var text8 = ""
    var text9 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_topic)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView5)
        textView5 = findViewById(R.id.textView8)
        textView6 = findViewById(R.id.textView9)
        textView7 = findViewById(R.id.textView10)
        textView8 = findViewById(R.id.textView11)
        textView9 = findViewById(R.id.textView12)

        image1 = findViewById(R.id.imageView4)
        image2 = findViewById(R.id.imageView6)
        image3 = findViewById(R.id.imageView7)
        image4 = findViewById(R.id.imageView8)
        image5 = findViewById(R.id.imageView9)
        image6 = findViewById(R.id.imageView10)
        image7 = findViewById(R.id.imageView11)
        image8 = findViewById(R.id.imageView12)



        if (baf == 1) {
            text1 = topicAndroid_1_1
            image1.setImageDrawable(getDrawable(R.drawable.android1))
            text2 = topicAndroid_1_2
            image2.setImageDrawable(getDrawable(R.drawable.android2))
        } else if (baf == 2) {
            text1 = topicAndroid_2_1
            image1.setImageDrawable(getDrawable(R.drawable.android3))
            text2 = topicAndroid_2_2
            image2.setImageDrawable(getDrawable(R.drawable.android4))
            text3 = topicAndroid_2_3
            image3.setImageDrawable(getDrawable(R.drawable.android5))
            text4 = topicAndroid_2_4
            image4.setImageDrawable(getDrawable(R.drawable.android6))
            text5 = topicAndroid_2_5
            image5.setImageDrawable(getDrawable(R.drawable.android7))
            text6 = topicAndroid_2_6
            image6.setImageDrawable(getDrawable(R.drawable.android8))
            text7 = topicAndroid_2_7
            image7.setImageDrawable(getDrawable(R.drawable.android9))
            text8 = topicAndroid_2_8
            image8.setImageDrawable(getDrawable(R.drawable.android10))
            text9 = topicAndroid_2_9

        } else if (baf == 3) {
            text1 = topicAndroid_3_1
            image1.setImageDrawable(getDrawable(R.drawable.android11))
            text2 = topicAndroid_3_2
            image2.setImageDrawable(getDrawable(R.drawable.android12))
            text3 = topicAndroid_3_3
            image3.setImageDrawable(getDrawable(R.drawable.android13))
            text4 = topicAndroid_3_4
            image4.setImageDrawable(getDrawable(R.drawable.android14))
            text5 = topicAndroid_3_5
            image5.setImageDrawable(getDrawable(R.drawable.android15))
            text6 = topicAndroid_3_6
        }

        textView1.text = (Html.fromHtml(text1))
        textView2.text = (Html.fromHtml(text2))
        textView3.text = (Html.fromHtml(text3))
        textView4.text = (Html.fromHtml(text4))
        textView5.text = (Html.fromHtml(text5))
        textView6.text = (Html.fromHtml(text6))
        textView7.text = (Html.fromHtml(text7))
        textView8.text = (Html.fromHtml(text8))
        textView9.text = (Html.fromHtml(text9))


        val btn = findViewById<Button>(R.id.buttonBack)
        btn.setOnClickListener {
            onBackPressed()
        }
    }
}