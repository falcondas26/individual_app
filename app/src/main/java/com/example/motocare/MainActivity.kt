package com.example.motocare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciarRegistro: Button = findViewById(R.id.btnIniciarRegistro)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        btnIniciarRegistro.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        btnSalir.setOnClickListener {
            finishAffinity()
        }
    }
}
