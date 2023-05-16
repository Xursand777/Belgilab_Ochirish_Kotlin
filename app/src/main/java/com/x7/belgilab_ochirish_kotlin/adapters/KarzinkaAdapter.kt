package com.x7.belgilab_ochirish_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x7.belgilab_ochirish_kotlin.databinding.RecyclerviewItem2Binding
import com.x7.belgilab_ochirish_kotlin.model.BelgilashModel

class KarzinkaAdapter constructor(
    val context: Context,
    val arrayList: ArrayList<BelgilashModel>

):RecyclerView.Adapter<KarzinkaAdapter.KarzinkaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KarzinkaViewHolder {
        val view=RecyclerviewItem2Binding.inflate(LayoutInflater.from(context),parent,false)
        return KarzinkaViewHolder(view)
    }

    override fun onBindViewHolder(holder: KarzinkaViewHolder, position: Int) {
        holder.binding.imageview2.setImageResource(arrayList.get(position).image)
        holder.binding.textview2.text=arrayList.get(position).name
    }
    override fun getItemCount(): Int =arrayList.size

    class KarzinkaViewHolder(val binding: RecyclerviewItem2Binding):RecyclerView.ViewHolder(binding.root)
}