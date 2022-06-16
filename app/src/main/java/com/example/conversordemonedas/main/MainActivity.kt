package com.example.conversordemonedas.main

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.conversordemonedas.R
import com.example.conversordemonedas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private var validation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        mainViewModel.mutableValidateDone.observe(this) { mutableValidate ->
            validation = mutableValidate
        }

        mainBinding.converterButton.setOnClickListener {

            if (mainBinding.initialMountEditText.text.toString().isEmpty()) {
                mainViewModel.emptyInput()
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.msg_number),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val quantity = (mainBinding.initialMountEditText.text.toString()).toInt()
                val inputMoneyType = mainBinding.startCoinSpinner.selectedItem.toString()
                val finalMoneyType = mainBinding.finalCoinSpinner.selectedItem.toString()

                mainViewModel.convertTo(inputMoneyType, finalMoneyType, quantity)

                mainViewModel.mutableResultDone.observe(this) { mutableResult ->
                    if (validation)
                        mainBinding.resultTextView.visibility = TextView.VISIBLE
                    mainBinding.resultTextView.text = getString(
                        R.string.info,
                        mutableResult.toString(),
                        mainBinding.finalCoinSpinner.selectedItem.toString()
                    )
                }
            }
            if (!validation){
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.msg_wrong),
                    Toast.LENGTH_SHORT
                ).show()
                mainBinding.resultTextView.visibility = TextView.INVISIBLE
            }


        }
    }
}