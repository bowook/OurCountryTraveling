package com.example.fragment_test_001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SeoulActivity : AppCompatActivity() {
    var traveloding : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seoul)

        var age = intent.getIntExtra("code", 0)

        Log.d("mbwd", "${age}")

        val seoulIntent = Intent(this@SeoulActivity, Fragment2::class.java)
        seoulIntent.putExtra("ing", traveloding)
    }
}