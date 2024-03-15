package br.com.pgabrelgmdeveloper.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var textInputPeso: TextInputLayout
    lateinit var textInputAltura: TextInputLayout
    lateinit var textEditPeso: TextInputEditText
    lateinit var textEditAltura: TextInputEditText
    lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initItems()

    }

    private fun initItems() {
        textInputPeso = findViewById(R.id.text_input_peso)
        textEditPeso = findViewById(R.id.edit_peso)
        textInputAltura = findViewById(R.id.text_input_altura)
        textEditAltura = findViewById(R.id.edit_altura)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnCalcular.setOnClickListener {
            navigateCalculoActivity()
        }
    }
    private fun navigateCalculoActivity() {
        var intent = Intent(this, IMCCalculuteActivity::class.java)
        val peso = textEditPeso.text.toString().toDouble()
        val altura = textEditAltura.text.toString().toDouble()
        intent.putExtra("peso",peso)
        intent.putExtra("altura",altura)
        startActivity(intent);

    }


}