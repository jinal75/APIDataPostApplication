package com.example.apidatapostappication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.EditText
import android.widget.Toast
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object Const  {

    fun isNetworkAvailable(context: Context): Boolean {
        val isAvailable: Boolean
        val connectivityMgr =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = Objects.requireNonNull(connectivityMgr).activeNetworkInfo
        isAvailable = networkInfo != null && networkInfo.isConnected
        return if (isAvailable) {
            true
        } else {
            Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show()

            false
        }
    }

    fun isEmptyEditTextOnClick(edt: EditText, error: String?, context: Context?): Boolean {
        val isValid: Boolean
        if (edt.text.toString().trim().length >= 0 ) {
            isValid = true
        } else {
            isValid = false
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    fun isValidEmail(edt: EditText, error: String?, context: Context?): Boolean {
        val isValid: Boolean
        val email = edt.text.toString().trim { it <= ' ' }
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z._-]+\\.+[a-z]+"
        if (email.length > 0 && email.matches(emailPattern.toRegex())) {
            isValid = true
        } else {
            isValid = false
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    fun isValidPassword(edt: EditText, error: String?, context: Context?): Boolean {
        val isValid: Boolean
        val password = edt.text.toString().trim { it <= ' ' }
        if (password.length >= 8 && isValidPasswordMatchPattern(password)) {
            isValid = true
        } else {
            isValid = false
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    private fun isValidPasswordMatchPattern(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher


        val PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"@#$%^&\'()*/:;<>+=?\\[\\]\\d_{}|~,-.`])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
}