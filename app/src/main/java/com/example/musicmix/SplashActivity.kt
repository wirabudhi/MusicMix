package com.example.musicmix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menunggu selama 3 detik
        Handler().postDelayed({
            // Menampilkan activity utama setelah splash screen
            startActivity(Intent(this, MainActivity::class.java))

            // Menutup activity splash
            finish()
        }, 3000)
    }
}