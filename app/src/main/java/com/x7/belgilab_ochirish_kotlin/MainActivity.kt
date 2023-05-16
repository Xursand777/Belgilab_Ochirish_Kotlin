package com.x7.belgilab_ochirish_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x7.belgilab_ochirish_kotlin.adapters.BelgilashAdapter
import com.x7.belgilab_ochirish_kotlin.databinding.ActivityMainBinding
import com.x7.belgilab_ochirish_kotlin.model.BelgilashModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var arrayList=ArrayList<BelgilashModel>()
    var selectedmode=false

    lateinit var belgilashAdapter: BelgilashAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showtoast("Assalomu Aleykum")

        arrayList= ArrayList()

        arrayList.add(BelgilashModel(R.drawable.rasm1,"Dubai"))
        arrayList.add(BelgilashModel(R.drawable.rasm2,"Palma"))
        arrayList.add(BelgilashModel(R.drawable.rasm3,"BMW"))

        binding.recyclerview1.layoutManager=LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
        belgilashAdapter=BelgilashAdapter(this@MainActivity,arrayList)
        binding.recyclerview1.adapter=belgilashAdapter



    }
}