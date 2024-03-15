package com.example.sweatify


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cjh.WaveProgressBarlibrary.WaveProgressBar
import java.util.Timer
import java.util.TimerTask

class WaterActivity : AppCompatActivity() {
    private var progress = 0
    private var started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        val waveProgressBar = findViewById<WaveProgressBar>(R.id.waveProgressBar)
        val timer = Timer()
        val timerTask = object : TimerTask() {
            override fun run() {
                if (started) {
                    progress++
                    runOnUiThread {
                        waveProgressBar.setProgress(progress)
                    }

                    if (progress == 100) {
                        progress = 0
                    }
                }
            }
        }

        timer.schedule(timerTask, 0, 80)

        waveProgressBar.setOnClickListener {
            started = !started
        }
    }
}


