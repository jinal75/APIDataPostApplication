package com.example.apidatapostappication

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.example.apidatapostappication.API.APIClient
import com.example.apidatapostappication.fragment.DegreeFragment
import com.example.apidatapostappication.fragment.SkillFragment
import com.example.apidatapostappication.utils.SessionManager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(){
    lateinit var txtDetails:TextView
    lateinit var image:ImageView
    lateinit var logout:Button
    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bar: Toolbar
    lateinit var sessionManager: SessionManager





    @SuppressLint("CheckResult", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager = findViewById(R.id.viewPager1)
        tab = findViewById(R.id.tabs1)
        txtDetails=findViewById(R.id.txt_Details1)
        logout = findViewById(R.id.btn_Logout1)
        image=findViewById(R.id.profileimg)

        sessionManager= SessionManager(this)

        val adapter = ViewPagerApapter(supportFragmentManager)
        val user: HashMap<String, String?> = sessionManager.candidateDetails
        txtDetails.append("UserName : ${user[SessionManager.KEY_FIRSTNAME]} ${user[SessionManager.KEY_LASTNAME]}")
        Glide.with(this).load(APIClient.IMAGE_URL+user[SessionManager.KEY_PROFILE_IMAGE]).optionalCircleCrop().into(image)
       logout.setOnClickListener {
           val alertdialog=AlertDialog.Builder(this)
           alertdialog.setTitle("LogOut")
           alertdialog.setIcon(R.drawable.img)
           alertdialog.setMessage("Are You Sure???")
           alertdialog.setCancelable(false)
           alertdialog.setPositiveButton("yes"){_,_,->
               sessionManager.logoutUser()
           }
           alertdialog.setNegativeButton("No"){_,_,->
               Toast.makeText(this, "Continue", Toast.LENGTH_SHORT).show()
           }
           alertdialog.setNeutralButton("Cancel"){_,_,->
               Toast.makeText(this, "cancle", Toast.LENGTH_SHORT).show()
           }
           val Alert=alertdialog.create()
           Alert.show()

          // sessionManager.logoutUser()
       }

            adapter.addFragment(SkillFragment(), "Skill")
        adapter.addFragment(DegreeFragment(), "Degree")
        pager.adapter = adapter
        tab.setupWithViewPager(pager)



    }




}





