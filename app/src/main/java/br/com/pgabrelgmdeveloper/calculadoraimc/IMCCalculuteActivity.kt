package br.com.pgabrelgmdeveloper.calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMCCalculuteActivity : AppCompatActivity() {
    lateinit var textAltura: TextView
    lateinit var textPeso: TextView
    lateinit var textDianostico: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imccalculute)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textAltura = findViewById(R.id.text_altura)
        textPeso = findViewById(R.id.text_peso)
        textDianostico = findViewById(R.id.text_resultado)
        calculate()
    }
    private fun calculate() {
        val extras = intent.extras;
        if (extras == null) {
            textDianostico.text = "A altura é peso devem ser informados!"
            return
        }

        val altura = extras.getDouble("altura")
        val peso = extras.getDouble("peso")
        val imc = peso / (altura * altura)
        val diagnostico = if (imc < 18.5) {
            "Abaixo do peso"
        }else if (imc in 18.5 .. 24.9) {
            "Saúdavel"
        } else if (imc in 25.0 .. 29.9) {
            "Sobre peso"
        } else {
            "Obeso"
        }
        textAltura.text = "Altura Infomada: $altura"
        textPeso.text = "Peso Infomada: $peso"
        textDianostico.text = diagnostico
    }
}