package br.com.brq.projetobrq

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handle = Handler()
        handle.postDelayed(Runnable {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }, 3000)

    }
}