package com.example.mymaps

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymaps.models.UserMap


private const val TAG= "MapsAdapter"
class MapsAdapter(val context : Context, val userMaps:List<UserMap> ,val onClickLister: OnClickLister) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {
  interface OnClickLister {
//      fun onItemClicked(position: Int){
//
//      }

      fun onItemClick(position: Int)
  }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent,false)
         return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val userMap = userMaps[position]
        holder.itemView.setOnClickListener{
            Log.i(TAG,"Tgged on position $position")
            onClickLister.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = userMap.title

    }

    override fun getItemCount() = userMaps.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
