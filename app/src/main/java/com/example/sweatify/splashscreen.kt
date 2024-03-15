package com.example.sweatify
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sweatify.onboarding

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startpage)

        // Duration in milliseconds for the splash screen
        val splashScreenDuration = 3000L // 3 seconds

        // Using a Handler to delay the transition
        Handler(mainLooper).postDelayed({
            // Start your main activity
            startActivity(Intent(this, MainActivity::class.java))
            // Close the splash activity so the user can't return to it
            finish()
        }, splashScreenDuration)
    }
}
