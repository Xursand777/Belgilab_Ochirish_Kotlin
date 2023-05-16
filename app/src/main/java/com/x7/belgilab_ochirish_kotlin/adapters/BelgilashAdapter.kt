package com.x7.belgilab_ochirish_kotlin.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.x7.belgilab_ochirish_kotlin.MainActivity
import com.x7.belgilab_ochirish_kotlin.MainActivity2
import com.x7.belgilab_ochirish_kotlin.databinding.RecyclerviewItemBinding
import com.x7.belgilab_ochirish_kotlin.model.BelgilashModel

class BelgilashAdapter constructor(
    val context: Context,
    val arrayList: ArrayList<BelgilashModel>
):RecyclerView.Adapter<BelgilashAdapter.BelgilashViewHoleder>() {
    var mainActivity=context as MainActivity
    var a=0

    val arraylistfordelete=ArrayList<BelgilashModel>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BelgilashViewHoleder {
        val viwe=RecyclerviewItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return BelgilashViewHoleder(viwe)
    }

    override fun onBindViewHolder(holder: BelgilashViewHoleder, position: Int) {
        holder.binding.imageview1.setImageResource(arrayList.get(position).image)
        holder.binding.textview1.text=arrayList.get(position).name

        holder.binding.apply {

            if (arrayList.get(position).selected){
                imageviewcheck.visibility=View.VISIBLE
            }else{
                imageviewcheck.visibility=View.INVISIBLE
            }
            relativlayout1.setOnClickListener {
                if (mainActivity.selectedmode){
                    arrayList.get(position).selected=!arrayList.get(position).selected
                    if (arrayList.get(position).selected){
                        imageviewcheck.visibility=View.VISIBLE
                        a++
                        mainActivity.binding.textviewappname.text="$a"
                        mainActivity.binding.textviewdeletecounter.text="$a"
                        mainActivity.binding.textviewshopcounter.text="$a"

                        arraylistfordelete.add(arrayList.get(position))
                    }else{
                        imageviewcheck.visibility= View.INVISIBLE
                        a--
                        arraylistfordelete.remove(arrayList.get(position))

                        mainActivity.binding.textviewappname.text="$a"
                        mainActivity.binding.textviewdeletecounter.text="$a"
                        mainActivity.binding.textviewshopcounter.text="$a"
                        if (a==0){
                            mainActivity.binding.imageviewclearmod.callOnClick()
                        }
                    }
                }
            }

            relativlayout1.setOnLongClickListener {
                mainActivity.selectedmode=true
                mainActivity.binding.textviewappname.text="$a"
                mainActivity.binding.imageviewclearmod.visibility=View.VISIBLE
                mainActivity.binding.relativelayfordelete.visibility=View.VISIBLE
                mainActivity.binding.relativlayoutbadge.visibility=View.VISIBLE
                mainActivity.binding.checkbox1.visibility=View.VISIBLE

                if (mainActivity.selectedmode){
                    arrayList.get(position).selected=!arrayList.get(position).selected
                    if (arrayList.get(position).selected){
                        imageviewcheck.visibility= View.VISIBLE
                        a++
                        arraylistfordelete.add(arrayList.get(position))

                        mainActivity.binding.textviewappname.text="$a"
                        mainActivity.binding.textviewdeletecounter.text="$a"
                        mainActivity.binding.textviewshopcounter.text="$a"

                    }else{
                        imageviewcheck.visibility= View.INVISIBLE
                        a--
                        arraylistfordelete.remove(arrayList.get(position))

                        mainActivity.binding.textviewappname.text="$a"
                        mainActivity.binding.textviewdeletecounter.text="$a"
                        mainActivity.binding.textviewshopcounter.text="$a"

                    }
                }

                return@setOnLongClickListener true
            }

            mainActivity.binding.imageviewclearmod.setOnClickListener {
                for (i in 0 until  arrayList.size){
                    arrayList.get(i).selected=false
                }
                notifyDataSetChanged()
                mainActivity.selectedmode=false
                a=0
                mainActivity.binding.imageviewclearmod.visibility=View.GONE
                mainActivity.binding.textviewappname.text="Cars"
                mainActivity.binding.relativelayfordelete.visibility=View.INVISIBLE
                mainActivity.binding.relativlayoutbadge.visibility=View.INVISIBLE
                mainActivity.binding.checkbox1.visibility=View.INVISIBLE

                arraylistfordelete.clear()
            }

//O'chirish-----------------O'chirish
            mainActivity.binding.relativelayfordelete.setOnClickListener {
                arrayList.removeAll(arraylistfordelete)
                notifyDataSetChanged()
                mainActivity.binding.imageviewclearmod.callOnClick()

            }
        }
        mainActivity.binding.checkbox1.setOnClickListener {
            arraylistfordelete.clear()
            if (mainActivity.binding.checkbox1.isChecked){
                for (i in 0 until arrayList.size){
                    arrayList.get(i).selected=true
                }
                a=arrayList.size
                arraylistfordelete.addAll(arrayList)
                mainActivity.binding.textviewappname.text="$a"
                mainActivity.binding.textviewdeletecounter.text="$a"
                mainActivity.binding.textviewshopcounter.text="$a"
            }else{
                mainActivity.binding.imageviewclearmod.callOnClick()
            }
            notifyDataSetChanged()
        }

       //Korsinka bosganda boshqa oynaga olib o'tishi

        mainActivity.binding.relativlayoutbadge.setOnClickListener {

            val intent=Intent(context,MainActivity2::class.java)
            intent.putExtra("korzinka",arraylistfordelete)
            context.startActivity(intent)
        }



    }
    override fun getItemCount(): Int =arrayList.size

    class BelgilashViewHoleder(val binding: RecyclerviewItemBinding):RecyclerView.ViewHolder(binding.root)

}