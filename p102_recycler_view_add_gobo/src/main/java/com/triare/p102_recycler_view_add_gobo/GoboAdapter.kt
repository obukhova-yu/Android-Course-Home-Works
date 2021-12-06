package com.triare.p102_recycler_view_add_gobo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.triare.p102_recycler_view_add_gobo.databinding.GoboItemBinding

class GoboAdapter : RecyclerView.Adapter<GoboAdapter.GoboHolder>( ) {

    val goboList = ArrayList<Gobo>()

    class GoboHolder(item:View):RecyclerView.ViewHolder(item){

        val binding = GoboItemBinding.bind(item)

        fun bind(gobo: Gobo) = with(binding){
        imageView.setImageResource(gobo.imageId)
            textView.text = gobo.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoboHolder {
        val view = LayoutInflater.from(parent.context ).inflate(R.layout.gobo_item,parent,false)
        return GoboHolder(view)
    }

    override fun onBindViewHolder(holder: GoboHolder, position: Int) {
        holder.bind(goboList[position])
    }

    override fun getItemCount(): Int {
        return goboList.size
    }

    fun addGobo(gobo: Gobo){
        goboList.add(gobo)
        notifyDataSetChanged()
    }

}