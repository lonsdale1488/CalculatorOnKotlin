package com.example.calculationonkitlin

import android.util.Log

class MainPresenter(var view: IMainView) {

    private val model by lazy { MainModel(this) }

    var textLine: String = "0"
    var LOGTAG = "MainPresenter"
    var number1 = 0.0
    var number2 = 0.0
    var number3 = 0.0
    var string1 = ""
    var string2 = ""
    var string3 = ""
    var firstText = ""
    var lastText = ""


    fun deleteAll() {
        textLine = "0"
        view.showtext(textLine)
        Log.d(LOGTAG, "deleteAll")
    }

    fun plusLine(sing: Char) {

        notDublicateAction(sing)
        view.showtext(textLine)

    }

    fun deleteLastSing() {
        var r = 0
        val arrayDeleteLigth = textLine.toCharArray()
        textLine = ""
        while (r <= arrayDeleteLigth.size - 2) {
            textLine = textLine + arrayDeleteLigth[r]
            r++
        }
        if (textLine.equals("")) {
            textLine = "0"
        }
        view.showtext(textLine)

    }

    fun getResult() {
        history(textLine)
        calcult('^')
        calcult('*')
        calcult('/')
        calcult('-')
        calcult('+')
        deletelastAction()
        deleteZeroAfteDate()
        view.showtext(textLine)
    }
    fun gerResult(position:Int) {
        textLine = model.getItem(position)
        view.showtext(textLine)
    }
    fun findAction(char: Char): Boolean {
        if (char == '+' || char == '-' || char == '*' || char == '/' || char == '^') {//Log.d(LOGTAG, " findAction + true")
            return true
        }
        return false
    }

    fun calcult(action: Char) {
        // робимо безкінечний цикл
        var a = 5
        while (a < 6) {

            val array = textLine.toCharArray()

            var i = 1
            // проходимо по всій стрічці
            while (i <= array.size - 1) {


                if (array[i] == action) {
                    var zk = false
                    //                   var k = i - 1
                    var k = i - 1

                    // визначаэмо всі цифрові знаки до попереднього знаку до нулю

                    while (!findAction(array[k])) {

                        string3 = ""
                        string3 += array[k]
                        string1 = string3 + string1
                        if (k == 0) {
                            k = -1
                            break
                        }
                        k--
                    }

                    var n = false
                    var m = i + 1
                    while (!findAction(array[m])) {
                        string2 += array[m]

                        if (m == array.size - 1) {
                            n = true
                            break
                        }
                        m++

                    }
                    var w: Int = k
                    var str1 = ""
                    Log.d(LOGTAG, "w + $w")
                    while (w >= 0) {
                        str1 = ""
                        str1 += array[w]
                        firstText = str1 + firstText
                        if (zk) {
                            firstText = ""
                        }
                        w--
                    }
                    var d = m
                    while (d <= array.size - 1) {
                        lastText += array[d]
                        d++
                        if (n) {
                            lastText = ""
                        }
                    }
                    number3 = 0.0
                    Log.d(LOGTAG, "String1 - $string1 ")
                    Log.d(LOGTAG, "String2 - $string2 ")
                    number1 = string1.toDouble()
                    number2 = string2.toDouble()
                    string1 = ""
                    string2 = ""
                    Log.d(LOGTAG, "firstText - $firstText")
                    Log.d(LOGTAG, "lastText - $lastText")
                    when (action) {
                        '^' -> number3 = Math.pow(number1.toDouble(), number2)
                        '*' -> number3 = number1 * number2
                        '+' -> if (array[0] == '-') {
                            number3 = -1 * number1 + number2
                            firstText = ""
                        } else {
                            number3 = number1 + number2
                        }

                        '-' -> if (array[0] == '-') {
                            number3 = -1 * number1 - number2
                            firstText = ""
                        } else {
                            number3 = number1 - number2
                        }
                        '/' -> number3 = number1 / number2
                    }
                    textLine = ""
                    textLine = firstText + number3.toString() + lastText
                    firstText = ""
                    lastText = ""
                    negativaNumber()

                    i = 0
                    Log.d(LOGTAG, "work brek in IF")
                    Log.d(LOGTAG, "textLine + $textLine")
                    break
                }
                i++
                if (i >= array.size - 1) {
                    break
                }
            }
            if (i >= array.size - 1) {
                break
            }

        }
    }

    fun deleteZeroAfteDate() {
        val arrayWithZero = textLine.toCharArray()
        var j = 0
        textLine = ""
        while (j <= arrayWithZero.size - 1) {
            if (arrayWithZero[j] == '.') {
                if (arrayWithZero[j + 1] == '0' && j + 1 == arrayWithZero.size - 1) {
                    break
                }
            }
            textLine = textLine + arrayWithZero[j]
            j++

        }
    }

    fun deletelastAction() {
        var text = ""
        var arrayCars = textLine.toCharArray()
        var i = 0
        if (findAction(textLine.get(textLine.length - 1))) {
            while (i <= arrayCars.size - 2) {
                text = text + arrayCars[i]
                i++
            }
            textLine = text
        }
    }

    fun notDublicateAction(sing: Char) {

        if (!findAction(sing) && sing != '.' && textLine == "0") {
            textLine = sing.toString()
            return
        }
        if (!findAction(textLine.get(textLine.length - 1)) || !findAction(sing)) {
            textLine = textLine + sing
        }

    }


    fun negativaNumber() {
        val arrayNegativeNumber = textLine.toCharArray()
        var p = 0
        textLine = ""
        while (p <= arrayNegativeNumber.size - 1) {

            if (arrayNegativeNumber[p] == '-' && p != arrayNegativeNumber.size - 1) {
                if (arrayNegativeNumber[p + 1] == '-') {
                    arrayNegativeNumber[p + 1] = '+'
                    p++
                    Log.d(LOGTAG, "work  -- ")
                    continue
                }
            }

            if (arrayNegativeNumber[p] == '+' && p != arrayNegativeNumber.size - 1) {
                if (arrayNegativeNumber[p + 1] == '-') {
                    p++
                    Log.d(LOGTAG, "work  ++ ")
                    continue
                }
            }
            textLine = textLine + arrayNegativeNumber[p]
            p++
        }

    }

    fun history(string: String) {
        view.setAdapter(model.putResult(string))
    }

    fun deleteHistory() {
        view.setAdapter(model.remuvALL())

    }


    fun plusMinus ()
    {
        if(textLine.get(0)=='-'){
            var i=1
            val arrayPlusMinus = textLine.toCharArray()
            textLine = ""
            while (i <= arrayPlusMinus.size - 1) {
                textLine = textLine + arrayPlusMinus[i]
                i++
            }
        }else {
            textLine = '-' + textLine
        }
        view.showtext(textLine)
    }

    fun saveList():ArrayList<String>
    {
     return  model.arrayList
    }

    fun saveText():String
    {
        return textLine
    }

}

