package com.example.apidatapostappication.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apidatapostappication.API.APIClient
import com.example.apidatapostappication.API.APIServices
import com.example.apidatapostappication.R
import com.example.apidatapostappication.model.DegreeList
import com.example.apidatapostappication.model.SkillDetails
import com.example.apidatapostappication.utils.ApiResponse
import com.example.apidatapostappication.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashBoardActivity : AppCompatActivity() {
    lateinit var txtDetails: TextView
    lateinit var getlist: Button

    lateinit var logout: Button
    var degreeLists: List<DegreeList>? = null
    var skillLists: List<SkillDetails>? = null
    lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        sessionManager = SessionManager(this)
        val user: HashMap<String, String?> = sessionManager!!.candidateDetails
        txtDetails = findViewById(R.id.txt_Details)
        logout = findViewById(R.id.btn_Logout)
        getlist = findViewById(R.id.btn_list)


        //Display the data of user
        txtDetails.append("UserName : ")
        txtDetails.append("""${user[SessionManager.KEY_FIRSTNAME]} ${user[SessionManager.KEY_LASTNAME]}""")



//        if (sessionManager!!.getSkillsDetail()!!.size > 0) {
//            txtDetails.append("\nSkillName : ")
//            txtDetails.append(sessionManager!!.getSkillsDetail()!!.get(0).getSkillName())
//        }
//        if (sessionManager!!.getExperienceDetail()!!.size > 0) {
//            txtDetails.append("\nCompanyName : ")
//            txtDetails.append(sessionManager!!.getExperienceDetail()!!.get(0).getCompanyName())
//        }

//        if (sessionManager!!.getDegreeDetail()!!.size > 0) {
//            txtDetails.append("\nDegreeName : ")
//            txtDetails.append(sessionManager!!.getDegreeDetail()!!.get(0).getDegreeName())
//
//        }
        logout.setOnClickListener {
            sessionManager!!.logoutUser()

        }
         getlist.setOnClickListener {

            DegreeList()

        }


    }

    private fun DegreeList() {
        val apiService: APIServices = APIClient.getClient()!!.create(APIServices::class.java)
        val call: Call<ApiResponse?>? = apiService.degreelist("en")
        call!!.enqueue(object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
                val statusCode = response.code()
                val msg = response.message()
                if (statusCode == 200) {
                    val data = response.body()
                   // val message: String = Objects.requireNonNull<Any?>(data).getMessage()
                    val status: Int = data!!.status!!
                    if (status == 1) {
                       // degreeLists = data!!.degreeList
                        SkillsList()
                    } else {
                        Toast.makeText(this@DashBoardActivity, "Data Not Found", Toast.LENGTH_SHORT)
                            .show()

                    }
                } else {
                    Toast.makeText(
                        this@DashBoardActivity,
                        "Something went wrong",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }


            override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }

    private fun SkillsList() {

    }

}








