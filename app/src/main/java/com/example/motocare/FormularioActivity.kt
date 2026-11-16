package com.example.motocare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etPropietario: EditText = findViewById(R.id.etPropietario)
        val etPlaca: EditText = findViewById(R.id.etPlaca)
        val etKilometraje: EditText = findViewById(R.id.etKilometraje)
        val rgTipoMoto: RadioGroup = findViewById(R.id.rgTipoMoto)

        val cbAceite: CheckBox = findViewById(R.id.cbAceite)
        val cbFrenos: CheckBox = findViewById(R.id.cbFrenos)
        val cbCadena: CheckBox = findViewById(R.id.cbCadena)
        val cbLlantas: CheckBox = findViewById(R.id.cbLlantas)

        val btnProcesar: Button = findViewById(R.id.btnProcesar)
        val btnVolver: Button = findViewById(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }

        btnProcesar.setOnClickListener {
            val propietario = etPropietario.text.toString().trim()
            val placa = etPlaca.text.toString().trim()
            val kilometraje = etKilometraje.text.toString().trim()

            if (propietario.isEmpty() || placa.isEmpty() || kilometraje.isEmpty()) {
                Toast.makeText(this, getString(R.string.err_empty_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioId = rgTipoMoto.checkedRadioButtonId
            if (selectedRadioId == -1) {
                Toast.makeText(this, getString(R.string.err_no_type), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val rbSeleccionado: RadioButton = findViewById(selectedRadioId)
            val tipoMoto = rbSeleccionado.text.toString()

            val servicios = mutableListOf<String>()
            if (cbAceite.isChecked) servicios.add(getString(R.string.service_oil))
            if (cbFrenos.isChecked) servicios.add(getString(R.string.service_brakes))
            if (cbCadena.isChecked) servicios.add(getString(R.string.service_chain))
            if (cbLlantas.isChecked) servicios.add(getString(R.string.service_tires))

            if (servicios.isEmpty()) {
                Toast.makeText(this, getString(R.string.err_no_services), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val serviciosTexto = servicios.joinToString("\n• ", prefix = "• ")

            val intent = Intent(this, AceptacionActivity::class.java).apply {
                putExtra("EXTRA_PROPIETARIO", propietario)
                putExtra("EXTRA_PLACA", placa.uppercase())
                putExtra("EXTRA_KILOMETRAJE", "$kilometraje km")
                putExtra("EXTRA_TIPO", tipoMoto)
                putExtra("EXTRA_SERVICIOS", serviciosTexto)
            }
            startActivity(intent)
        }
    }
}
