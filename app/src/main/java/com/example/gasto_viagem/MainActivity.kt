package com.example.gasto_viagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcular.setOnClickListener(this)
    }

    private fun calcularViagem() {
        if (!validarCampos()) return

        val distancia = et_distancia.text.toString().toDouble()
        val precoGasolina = et_preco.text.toString().toDouble()
        val autonomia = et_autonomia.text.toString().toDouble()

        val custoDaViagem = (distancia * precoGasolina ) / autonomia

        val textoFormatado = "${"%.2f".format(custoDaViagem)} R$"

        tv_valor_total.text = textoFormatado
    }

    private fun validarCampos(): Boolean {
        if (et_distancia.text.isEmpty() || et_preco.text.isEmpty() || (
                    et_autonomia.text.isEmpty() ||
                            et_autonomia.text.toString().toDouble().equals(0.0))
        ) {
            val text = "Preencha todos os campos com valores válidos!"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            return false;
        }
        return true;
    }

    override fun onClick(v: View) {
        when (v.id) {
            bt_calcular.id -> calcularViagem()
        }
    }
}