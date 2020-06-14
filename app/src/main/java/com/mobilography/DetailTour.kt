package com.mobilography

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobilography.ui.courses.tours.TourViewModel
import com.mobilography.ui.courses.tours.TourViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_tour.*

class DetailTour : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour)
        initialize()
    }

    fun initialize() {
        reg_tour.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            Toast.makeText(this, "You successfully registered in Tour trip!", Toast.LENGTH_LONG).show()
        }
    }

}
