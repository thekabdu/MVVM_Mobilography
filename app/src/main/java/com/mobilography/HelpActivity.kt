package com.mobilography

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        setupViews()
    }

    private fun setupViews(){
        cardtour.setOnClickListener{
            val intent = Intent(this, TourCardHelp::class.java)
            startActivity(intent)
        }
    }

}
