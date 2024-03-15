package com.example.sweatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    private var progr = 0
    private lateinit var progressBar: ProgressBar
    private lateinit var progressBarText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the click listeners
        findViewById<ConstraintLayout>(R.id.calories).setOnClickListener {
            startActivity(Intent(this, CaloriesActivity::class.java))
        }

        findViewById<ConstraintLayout>(R.id.steps).setOnClickListener {
            startActivity(Intent(this, ExersiceActivity::class.java))
        }

        findViewById<ConstraintLayout>(R.id.sleep).setOnClickListener {
            startActivity(Intent(this, SleepActivity::class.java))
        }
        findViewById<ConstraintLayout>(R.id.water).setOnClickListener {
            startActivity(Intent(this, WaterActivity::class.java))
        }

        progressBar = findViewById(R.id.progressBar)
        progressBarText = findViewById(R.id.progressBarText)
        updateProgressBar()

        val buttonI = findViewById<Button>(R.id.btn_inc)
        val buttonD = findViewById<Button>(R.id.btn_dec)

        buttonI.setOnClickListener {
            if (progr <= 90) {
                progr += 10
                updateProgressBar()
            }
        }

        buttonD.setOnClickListener {
            if (progr >= 10) {
                progr -= 10
                //updateProgressBar()
                Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
            }
        }

        // Find the navigation button by its ID and set a click listener
        val buttonNavigate = findViewById<Button>(R.id.next)
        buttonNavigate.setOnClickListener {
            // Create an Intent to navigate to SecondActivity
            val intent = Intent(this, WaterActivity::class.java)
            startActivity(intent)

//            val constraintLayout: ConstraintLayout = findViewById(R.id.water)
//            constraintLayout.setOnClickListener {
//              val intent = Intent(this, WaterActivity::class.java)
//                startActivity(intent)
       }
    }

    private fun updateProgressBar() {
        progressBar.progress = progr
        progressBarText.text = "$progr%"
    }
}
