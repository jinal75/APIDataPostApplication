package com.example.apidatapostappication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.apidatapostappication.R
import com.example.apidatapostappication.ViewPagerApapter
import com.example.apidatapostappication.fragment.DegreeFragment
import com.example.apidatapostappication.fragment.SkillFragment
import com.google.android.material.tabs.TabLayout

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}