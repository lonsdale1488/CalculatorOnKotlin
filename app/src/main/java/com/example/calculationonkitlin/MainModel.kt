package com.example.calculationonkitlin

import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

class MainModel   ( var  prenter: MainPresenter) {

    var arrayList = arrayListOf<String>("")



   fun putResult (string:String):ArrayList<String>
   {
       arrayList.add(string)
       return arrayList
   }

    fun remuvALL ():ArrayList<String>
    {
        arrayList.clear()
        return arrayList

    }

}