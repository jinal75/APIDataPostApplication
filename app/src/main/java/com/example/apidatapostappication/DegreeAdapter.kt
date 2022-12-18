package com.example.apidatapostappication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apidatapostappication.model.DegreeDetails
import com.example.apidatapostappication.model.DegreeList

class DegreeAdapter (private val list:ArrayList<DegreeDetails>):
    RecyclerView.Adapter<DegreeAdapter.viewholder>(){
    class viewholder (itemView: View):RecyclerView.ViewHolder(itemView){
        val did:TextView=itemView.findViewById(R.id.txt_Did)
        val dname:TextView=itemView.findViewById(R.id.txt_DName)
        val dactive:TextView=itemView.findViewById(R.id.txt_DActive)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
      return  viewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_degree_adpter,parent,false))

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       val dlist=list[position]
        holder.did.text= dlist.degreeID.toString()
        holder.dname.text=dlist.degreeName
        holder.dactive.text= dlist.isActive.toString()
    }

    override fun getItemCount(): Int {
        return list.size

    }

}