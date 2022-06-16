package com.example.conversordemonedas.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.conversordemonedas.databinding.ActivitySplashBinding
import com.example.conversordemonedas.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

private lateinit var splashBinding: ActivitySplashBinding

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(
            timerTask{
                goToMainActivity()
            }, 1000
        )
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}