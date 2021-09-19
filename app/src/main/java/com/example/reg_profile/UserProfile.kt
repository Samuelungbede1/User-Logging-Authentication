package com.example.reg_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)



        val name = intent.getStringExtra("name")
        val  mobile= intent.getStringExtra("mobile")
        val  mail= intent.getStringExtra("mail")
        val sex= intent.getStringExtra("sex")


        findViewById<TextView>(R.id.text_name).text = name
        findViewById<TextView>(R.id.text_phone).text= mobile
        findViewById<TextView>(R.id.text_mail).text= mail
        findViewById<TextView>(R.id.text_sex).text= sex
    }
}