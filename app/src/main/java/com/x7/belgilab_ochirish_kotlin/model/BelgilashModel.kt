package com.x7.belgilab_ochirish_kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class BelgilashModel constructor(
    val image:Int,
    val name:String,
    var selected:Boolean=false
): Parcelable