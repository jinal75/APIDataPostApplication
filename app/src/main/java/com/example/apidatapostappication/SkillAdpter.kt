package com.example.apidatapostappication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apidatapostappication.model.DegreeList
import com.example.apidatapostappication.model.SkillDetails

import java.nio.file.Files.size

class SkillAdpter(val context: Context?, val skilllist: ArrayList<SkillDetails>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_skill_adapter, parent, false)
        )


    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        holder.itemView.findViewById<TextView>(R.id.txt_sid).text = skilllist[position].sKillID.toString()
        holder.itemView.findViewById<TextView>(R.id.txt_sName).text=skilllist[position]. skillName
        holder.itemView.findViewById<TextView>(R.id.txt_sActive).text=skilllist[position].isActive.toString()


    }

    override fun getItemCount(): Int = skilllist.size

}



