package com.viniciusaraujo.routemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CorridaMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corrida_main)
        supportActionBar?.hide()
    }
}