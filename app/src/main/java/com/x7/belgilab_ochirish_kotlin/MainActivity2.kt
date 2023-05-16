package com.x7.belgilab_ochirish_kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x7.belgilab_ochirish_kotlin.adapters.BelgilashAdapter
import com.x7.belgilab_ochirish_kotlin.adapters.KarzinkaAdapter
import com.x7.belgilab_ochirish_kotlin.databinding.ActivityMain2Binding
import com.x7.belgilab_ochirish_kotlin.model.BelgilashModel

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = getIntent()
        val arrayListkarzinka = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
             intent.getParcelableArrayListExtra("korzinka",BelgilashModel::class.java)
        } else {
            intent.getParcelableArrayListExtra<BelgilashModel>("korzinka")
        }
        var arrayList1 =if (arrayListkarzinka is ArrayList<BelgilashModel>){
            arrayListkarzinka
        }else{
            null
        }

        binding.recyclerview2.layoutManager=LinearLayoutManager(this@MainActivity2,RecyclerView.VERTICAL,false)
        val adapterkarzinka=KarzinkaAdapter(this@MainActivity2, arrayList1!!)
        binding.recyclerview2.adapter=adapterkarzinka
        showtoast("${arrayListkarzinka!!.size}")





    }
}