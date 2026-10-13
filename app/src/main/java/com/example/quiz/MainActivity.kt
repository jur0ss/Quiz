package com.example.quiz

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        data class Pytanie(
            var tresc: String = "",
            var img: String = ""
        )

        val listPytan = arrayOf<Pytanie>(
            Pytanie("Jak nazywa sie ta mapa", "lake,jpg")
        )

        val pytanieImageView: ImageView = findViewById(R.id.pytanieImageView)
        var pytanieTextView: TextView = findViewById(R.id.pytanieTextView)
        val odpowiedzTextView: TextView = findViewById(R.id.odpowiedzTextView)
        val odpowiedz2TextView: TextView = findViewById(R.id.odpowiedz2TextView)
        val odpowiedz3TextView: TextView = findViewById(R.id.odpowiedz3TextView)
        val dalejButton: Button = findViewById(R.id.dalejButton)


    }




}