package com.gafasmatch.visualstyle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)
        val textViewVersion: TextView = findViewById(R.id.textViewVersion)
        val btnContact: Button = findViewById(R.id.btnContact)

        // Obtener el nombre de usuario de MainActivity
        val username = intent.getStringExtra("username")

        // Configurar el texto en TextViews
        textViewVersion.text = "$username, estás usando la versión 1 de..."


        // Configurar el botón de contacto
        btnContact.setOnClickListener {
            enviarCorreoConsulta()
        }
    }

    private fun enviarCorreoConsulta() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cmaclim365@g.educaand.es"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app GafasMatch")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}