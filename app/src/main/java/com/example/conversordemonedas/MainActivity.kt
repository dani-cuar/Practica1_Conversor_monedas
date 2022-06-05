package com.example.conversordemonedas

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.example.conversordemonedas.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val dolarPesoCo: Double = 3781.36
    private val dolarPesoMex: Double = 19.55
    private val pesoCoDolar: Double = 0.00026
    private val pesoCoMex: Double = 0.0052
    private val pesoMexPesoCo: Double = 193.47
    private val pesoMexDolar: Double = 0.051
    private var result: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){

            converterButton.setOnClickListener{

                if(initialMountEditTextNumber3.getText().toString().isEmpty())
                    Toast.makeText(this@MainActivity, getString(R.string.msg_number), Toast.LENGTH_SHORT).show()

                val num = (initialMountEditTextNumber3.getText().toString()).toInt()

                val input_money_type = startCoinSpinner.selectedItem.toString()
                val final_money_type = finalCoinSpinner2.selectedItem.toString()

                if(input_money_type=="Dólar Estadounidense") {
                    if (final_money_type == "Peso Colombiano") result = num * dolarPesoCo
                    else if (final_money_type == "Peso Mexicano")result = num * dolarPesoMex
                    else {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.msg_wrong),
                            Toast.LENGTH_SHORT
                        ).show()
                        result = num.toDouble()
                    }
                }
                else if(input_money_type=="Peso Colombiano") {
                    if (final_money_type == "Dólar Estadounidense") result = num * pesoCoDolar
                    else if (final_money_type == "Peso Mexicano") result = num * pesoCoMex
                    else {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.msg_wrong),
                            Toast.LENGTH_SHORT
                        ).show()
                        result = num.toDouble()
                    }
                }
                else if(input_money_type=="Peso Mexicano") {
                    if (final_money_type == "Peso Colombiano") result = num * pesoMexPesoCo
                    else if (final_money_type == "Dólar Estadounidense") result = num * pesoMexDolar
                    else {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.msg_wrong),
                            Toast.LENGTH_SHORT
                        ).show()
                        result = num.toDouble()
                    }
                }

                var salida = result.toString()
                resultTextView5.text = getString(R.string.info, salida)
            }
        }

    }
}