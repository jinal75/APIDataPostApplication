package com.example.apidatapostappication.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.apidatapostappication.R
import com.example.apidatapostappication.utils.SessionManager


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    var handler = Handler(Looper.getMainLooper())
    var session: SessionManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        session = SessionManager(this)

        //After 2 sec this handler called
        handler.postDelayed({
            session!!.checkLogin()
            finish()
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        //Remove the handler
        handler.removeCallbacksAndMessages(null)
    }
}