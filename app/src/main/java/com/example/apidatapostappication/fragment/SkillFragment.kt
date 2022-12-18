package com.example.apidatapostappication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidatapostappication.API.APIClient
import com.example.apidatapostappication.API.APIServices
import com.example.apidatapostappication.R
import com.example.apidatapostappication.SkillAdpter
import com.example.apidatapostappication.model.SkillDetails

import com.example.apidatapostappication.utils.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillFragment : Fragment() {
   lateinit var skillLists: List<SkillDetails>
    lateinit var RecyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_skill, container, false)
        SkillsList()
        RecyclerView = view.findViewById<RecyclerView>(R.id.srecycler)
return  view
    }

    fun SkillsList(){
        val apiService: APIServices = APIClient.getClient()!!.create(APIServices::class.java)
        val call: Call<ApiResponse?>? = apiService.skilllist("en")
        call!!.enqueue(object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
                val statusCode = response.code()
                val msg = response.message()
                if (statusCode == 200) {
                    val data: ApiResponse? = response.body()
                    // val message: String = Objects.requireNonNull<Any?>(data).getMessage()
                    val status: Int? = data!!.status
                    if (status == 1) {
                        skillLists = data.skillList!!
                        RecyclerView.layoutManager = LinearLayoutManager(context)
                        RecyclerView.adapter = SkillAdpter(context, skillLists as ArrayList<SkillDetails>)
                    } else {
                        Toast.makeText(context, "Data Not Found", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(
                        context,
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


}