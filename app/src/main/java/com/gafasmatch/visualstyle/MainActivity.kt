package com.gafasmatch.visualstyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGoToCredit: Button = findViewById(R.id.btnGoToCredit)

        btnGoToCredit.setOnClickListener {
            // Obtener el nombre de usuario del EditText
            val username = findViewById<EditText>(R.id.editTextUsuario).text.toString()

            val intent = Intent(this, CreditActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}