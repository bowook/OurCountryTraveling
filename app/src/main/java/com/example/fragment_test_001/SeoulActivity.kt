package com.example.fragment_test_001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SeoulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seoul)

        val age = intent.getIntExtra("code", 0)

        Log.d("mbwd", "${age}")
    }
}