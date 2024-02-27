package com.gafasmatch.visualstyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2000 // 2 segundos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crea un Handler para postergar el inicio de MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Crea un Intent para iniciar MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Inicia MainActivity
            startActivity(intent)
            // Cierra SplashActivity
            finish()
        }, SPLASH_TIME_OUT)
    }
}