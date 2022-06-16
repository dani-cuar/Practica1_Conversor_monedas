package com.example.conversordemonedas.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.conversordemonedas.R

class MainViewModel : ViewModel() {

    private val dolarPesoCo: Double = 3781.36
    private val dolarPesoMex: Double = 19.55
    private val pesoCoDolar: Double = 0.00026
    private val pesoCoMex: Double = 0.0052
    private val pesoMexPesoCo: Double = 193.47
    private val pesoMexDolar: Double = 0.051


    private val mutableResult: MutableLiveData<Double> = MutableLiveData()
    val mutableResultDone: LiveData<Double> = mutableResult

    private val mutableValidate: MutableLiveData<Boolean> = MutableLiveData()
    val mutableValidateDone: LiveData<Boolean> = mutableValidate

    fun convertTo(initial: String, final: String, quantity: Int){
        if (initial == "Dólar Estadounidense") {
            if (final == "Peso Colombiano") {
                mutableResult.value = quantity * dolarPesoCo
                mutableValidate.value = true
            }
            else if (final == "Peso Mexicano") {
                mutableResult.value = quantity * dolarPesoMex
                mutableValidate.value = true
            }
            else {
                mutableValidate.value = false
            }
        } else if (initial == "Peso Colombiano") {
            if (final == "Dólar Estadounidense") {
                mutableResult.value = quantity * pesoCoDolar
                mutableValidate.value = true
            }
            else if (final == "Peso Mexicano") {
                mutableResult.value = quantity * pesoCoMex
                mutableValidate.value = true
            }
            else {
                mutableValidate.value = false
            }
        } else if (initial == "Peso Mexicano") {
            if (final == "Peso Colombiano") {
                mutableResult.value = quantity * pesoMexPesoCo
                mutableValidate.value = true
            }
            else if (final == "Dólar Estadounidense") {
                mutableResult.value = quantity * pesoMexDolar
                mutableValidate.value = true
            }
            else {
                mutableValidate.value = false
            }
        }
    }

    fun emptyInput(){
        mutableResult.value = 0.0
        mutableValidate.value = false
    }

}