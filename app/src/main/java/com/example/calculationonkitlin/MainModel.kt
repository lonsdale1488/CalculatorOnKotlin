package com.example.calculationonkitlin


class MainModel(var prenter: MainPresenter) {

    var arrayList = arrayListOf<String>()
    var text = ""


    fun putResult(string: String): ArrayList<String> {
        arrayList.add(string)
        return arrayList
    }

    fun remuvALL(): ArrayList<String> {
        arrayList.clear()
        return arrayList

    }
    fun getItem(position:Int):String { return arrayList.get(position)

    }
}