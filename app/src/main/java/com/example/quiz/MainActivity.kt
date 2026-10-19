package com.example.quiz

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
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
            var img: Int = 0,
            var trescOdpowiedziA: String = "",
            var trescOdpowiedziB: String = "",
            var trescOdpowiedziC: String = "",
            var poprawnaOdpowiedz: Char,
        )

        val listaPytan = arrayOf<Pytanie>(
            Pytanie("Jak nazywa sie ta mapa?", R.drawable.lake,
                "Rialto", "Lake",
                "Safehouse", 'B'),
            Pytanie("Ile dolarów kosztuje AWP?", R.drawable.awp, "3500", "4250", "4750", 'C'),
            Pytanie("Jaki nick ma ten gracz komputerowy?", R.drawable.snax, "Snax", "pashaBiceps", "NEO", 'A')
        )

        var pytanieImageView: ImageView = findViewById(R.id.pytanieImageView)
        var pytanieTextView: TextView = findViewById(R.id.pytanieTextView)
        val odpowiedzRadio: RadioButton = findViewById(R.id.odpowiedzARadio)
        val odpowiedz2Radio: RadioButton = findViewById(R.id.odpowiedzBRadio)
        val odpowiedz3Radio: RadioButton = findViewById(R.id.odpowiedzCRadio)
        val dalejButton: Button = findViewById(R.id.dalejButton)
        val radioGrupa: RadioGroup = findViewById(R.id.radioGroup)


        fun zaladujPytanie(index: Int)
        {
            val pytanie = listaPytan[index]
            pytanieImageView.setImageResource(pytanie.img)
            pytanieTextView.text = pytanie.tresc
            odpowiedzRadio.text = pytanie.trescOdpowiedziA
            odpowiedz2Radio.text = pytanie.trescOdpowiedziB
            odpowiedz3Radio.text = pytanie.trescOdpowiedziC
        }


        var index = 0

        var punkty = 0

        zaladujPytanie(index)

        dalejButton.setOnClickListener {
            val pytanie = listaPytan[index]

            val czyPoprawna = when(pytanie.poprawnaOdpowiedz) {
                'A' -> odpowiedzRadio.isChecked
                'B' -> odpowiedz2Radio.isChecked
                'C' -> odpowiedz3Radio.isChecked
                else -> false
            }

            if(czyPoprawna) {
                punkty++
                Toast.makeText(this, "Dobrze, masz teraz ${punkty} punktów", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Źle", Toast.LENGTH_SHORT).show()
            }

            index++
            if (index == listaPytan.size) {
                index = 0
                punkty = 0
            }

            zaladujPytanie(index)

            radioGrupa.clearCheck()


        }


    }




}