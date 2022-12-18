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
import com.example.apidatapostappication.DegreeAdapter
import com.example.apidatapostappication.R
import com.example.apidatapostappication.model.DegreeDetails
import com.example.apidatapostappication.model.DegreeList
import com.example.apidatapostappication.utils.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DegreeFragment : Fragment() {
   lateinit var degreeLists: List<DegreeDetails>
    lateinit var RecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
       val view =inflater.inflate(R.layout.fragment_degree, container, false)
        DegreeList()
        RecyclerView = view.findViewById<RecyclerView>(R.id.drecycler)
        return  view
    }
    fun DegreeList() {
        val apiService: APIServices = APIClient.getClient()!!.create(APIServices::class.java)
        val call: Call<ApiResponse?>? = apiService.degreelist("en")
        call!!.enqueue(object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
                val statusCode = response.code()
                val msg = response.message()
                if (statusCode == 200) {
                    val data: ApiResponse? = response.body()
                    //val message: String = Objects.requireNonNull<Any?>(data).getMessage()
                    val status: Int? = data!!.status
                    if (status==1){

                        degreeLists = data.degreeList!!
                        RecyclerView.layoutManager = LinearLayoutManager(context)
                       RecyclerView.adapter = DegreeAdapter( degreeLists as ArrayList<DegreeDetails>)

                    } else {
                        Toast.makeText(context, "Data Not Found", Toast.LENGTH_SHORT).show()

                    }
                } else {
                    Toast.makeText(context,
                        "Something went wrong",
                        Toast.LENGTH_SHORT
                        ).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }
}
