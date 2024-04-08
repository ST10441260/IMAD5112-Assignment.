package com.example.myhistoryapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//Declaring the views
        val ageNumber = findViewById<EditText>(R.id.ageNumber)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnCancel = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResults)
        btnGenerate.setOnClickListener {
            val age = ageNumber.text.toString().toIntOrNull()
            if (age != null) {
                val result = when (age) {
                    in 20..29 -> "No one"
                    in 30..39 -> "Martin Luther King"
                    in 40..49 -> "Malcolm X, John F. Kennedy"
                    in 50..59 -> "Adolf Hitler, Chris Hani"
                    in 60..69 -> "Steve Jobs"
                    in 70..79 -> "Mahatma Gandhi"
                    in 80..89 -> "No one"
                    in 90..100 -> "Nelson Mandela, Winston Churchill, Desmond Tutu"
                    else -> "invalid age"
                }
                txtResult.text = "Age: $age\n${
                    when (result) {
                        "No one" -> "No historical passed away between 20 and 29."
                        "Martin Luther King" -> "Martin Luther King passed away at the age of 39."
                        "Malcolm X, John F. Kennedy" -> "Malcolm X passed away at the age of 40, John F. Kennedy passed away at the age of 46."
                        "Adolf Hitler, Chris Hani" -> "Adolf Hitler passed away at the age of 56, Chris Hani passed away at the of 51."
                        "Steve Jobs" -> "Steve Jobs passed away at the age of 65."
                        "Mahatma Gandhi" -> "Mahatma Gandhi passed away at the age of 79"
                        "No one" -> "No historial passed away between 80 and 89."
                        "Nelson Mandela, Winston Churchill, Desmond Tutu" -> "Nelson Mandela passed away at the age of 95, Winston Churchilll passed away at the age of 91, Desmond Tutu passed away at the age of 90"
                        else -> "invalid age"
                    }
                }"
            } else {
                txtResult.text = "please enter valid age."
            }

        }

        btnCancel.setOnClickListener {
            ageNumber.text.clear()
            txtResult.text = ""
        }

    }

}
