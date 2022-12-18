package com.example.apidatapostappication.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apidatapostappication.API.APIClient
import com.example.apidatapostappication.API.APIServices
import com.example.apidatapostappication.MainActivity
import com.example.apidatapostappication.R
import com.example.apidatapostappication.model.*
import com.example.apidatapostappication.utils.ApiResponse
import com.example.apidatapostappication.utils.Const
import com.example.apidatapostappication.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var ForgotPassword: TextView
    lateinit var Signin: Button
    var progressDialog: ProgressDialog? = null
    var sessionManager: SessionManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        Email = findViewById(R.id.edt_Email)
        Password = findViewById(R.id.edt_Password)
        ForgotPassword = findViewById(R.id.txt_ForgotPass)
        Signin = findViewById(R.id.btn_Signin)
        sessionManager = SessionManager(this)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Loading")
        Signin.setOnClickListener {
            val email: String = Email.getText().toString().trim()
            val password: String = Password.getText().toString().trim()

            if (Const.isNetworkAvailable(this)
                && Const.isEmptyEditTextOnClick(Email, "Enter Email", this)
                && Const.isValidEmail(Email, "Please Enter Valid Email", this)
                && Const.isEmptyEditTextOnClick(Password, "Enter Password", this)
                && Const.isValidPassword(Password, "Plaease Enter Valid Password", this)
            ){

                //Call the Login API
               progressDialog?.show()
                login(email, password, "123", "en")

            }

        }
    }


    fun login(email: String, password: String, s: String, s1: String) {
       // Toast.makeText(this, "login", Toast.LENGTH_SHORT).show()
        val apiService: APIServices = APIClient.getClient()!!.create(APIServices::class.java)
        val call = apiService.login(email, password, s, s1)
        call!!.enqueue(object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
                val statusCode = response.code()
                val msg = response.message()
                if (statusCode == 200) {
                    val data = response.body()
                  //  val message: String = Objects.requireNonNull<Any?>(data).message
                    val status: Int? = data!!.status


                    if (status == 1) {

                        //Get Response from API
                        val userDataCandidate: UserDataCandidate? = data.userData
                        val skillDetail: List<SkillDetail> = data.skillDetails as List<SkillDetail>
                        val experienceDetails: List<ExperienceDetail> = data.experienceDetails as List<ExperienceDetail>
                       val degree: List<Degree> = data.degree as List<Degree>
                        //Store data in the session
                        sessionManager!!.createLoginSessionCandidate(userDataCandidate!!. userId.toString(),
                            userDataCandidate.userType.toString(),
                            userDataCandidate.firstName.toString(),
                            userDataCandidate.lastName.toString(),
                            userDataCandidate. email.toString(),
                            userDataCandidate.profilePic.toString(),
                            userDataCandidate.profilePic.toString(),
                            userDataCandidate. resume.toString(),
                            userDataCandidate. resumeLink.toString() ,
                            userDataCandidate. langauge.toString(),
                            userDataCandidate. authenicateToken.toString()).toString()

                        sessionManager!!.setDegreeDetail(degree)
                        sessionManager!!.setSkillsDetail(skillDetail)
                        sessionManager!!.setExperienceDetail(experienceDetails)

                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this@SignInActivity, "Data Not Found", Toast.LENGTH_SHORT).show()


                }
            }


            override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
                Log.e("Error", t.toString())
                progressDialog!!.dismiss()
                Toast.makeText(this@SignInActivity, "Something went wrong.", Toast.LENGTH_SHORT)
                    .show()


            }
        })
    }
}














