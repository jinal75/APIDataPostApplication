package com.example.apidatapostappication.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.example.apidatapostappication.R
import com.example.apidatapostappication.activities.SignInActivity

class CustomeProgressDialog(signInActivity: SignInActivity) {
    private var activity: Activity? = null
    private var infoText = ""
    private var dialog: AlertDialog? = null
    private var alertDialogBuilder: AlertDialog.Builder? = null
    private val progress: ProgressBar? = null

    fun CustomProgressDialog(activity: Activity?) {
        this.activity = activity
        // customProgressDialog = new Dialog(this.activity);
        alertDialogBuilder = AlertDialog.Builder(this.activity!!)
        dialog = alertDialogBuilder!!.create()
    }

    fun setTitle(infoText: String) {
        this.infoText = infoText
    }

    fun show() {
        if (!dialog!!.isShowing) {
            //customProgressDialog.show();
            openCustomProgressDialog()
        }
    }

    fun dismiss() {
        if (dialog != null) {
            if (dialog!!.isShowing) if (progress != null) {
               progress.progress
            }
            dialog!!.dismiss()
        }
    }

    fun isShowing(): Boolean {
        return if (dialog!!.isShowing) {
            true
        } else false
    }

    fun getDialog(): Dialog? {
        return dialog
    }

    @SuppressLint("InflateParams")
    fun openCustomProgressDialog() {
        try {
            dialog = alertDialogBuilder!!.create()
            dialog!!.setCancelable(false)
            dialog!!.setCanceledOnTouchOutside(false)
            dialog!!.setView(activity!!.layoutInflater.inflate(R.layout.dialog_custom_progess,
                null))
            dialog!!.window!!.setBackgroundDrawable(
                ColorDrawable(Color.TRANSPARENT))
            val prog: ProgressBar? = dialog!!.findViewById(R.id.progress)
            if (prog != null) {
                prog.progress
            }
            dialog!!.show()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}
