package com.example.motocare

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AceptacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aceptacion)

        val tvResumenPropietario: TextView = findViewById(R.id.tvResumenPropietario)
        val tvResumenPlaca: TextView = findViewById(R.id.tvResumenPlaca)
        val tvResumenKilometraje: TextView = findViewById(R.id.tvResumenKilometraje)
        val tvResumenTipo: TextView = findViewById(R.id.tvResumenTipo)
        val tvResumenServicios: TextView = findViewById(R.id.tvResumenServicios)

        val btnNuevoRegistro: Button = findViewById(R.id.btnNuevoRegistro)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        val propietario = intent.getStringExtra("EXTRA_PROPIETARIO") ?: ""
        val placa = intent.getStringExtra("EXTRA_PLACA") ?: ""
        val kilometraje = intent.getStringExtra("EXTRA_KILOMETRAJE") ?: ""
        val tipoMoto = intent.getStringExtra("EXTRA_TIPO") ?: ""
        val servicios = intent.getStringExtra("EXTRA_SERVICIOS") ?: ""

        tvResumenPropietario.text = propietario
        tvResumenPlaca.text = placa
        tvResumenKilometraje.text = kilometraje
        tvResumenTipo.text = tipoMoto
        tvResumenServicios.text = servicios

        btnNuevoRegistro.setOnClickListener {
            finish()
        }

        btnSalir.setOnClickListener {
            finishAffinity()
        }
    }
}
