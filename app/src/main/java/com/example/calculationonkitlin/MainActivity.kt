package com.example.calculationonkitlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, IMainView {
    override fun showtext(string: String) {
        tvResult.text = string
    }

//    override fun showtekst() {
//        tvResult.text = presenter.textLine
//    }


    private val presenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        initLisener()
    }


    private fun initLisener() {
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        dot.setOnClickListener(this)
        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divate.setOnClickListener(this)
        step.setOnClickListener(this)
        result.setOnClickListener(this)
        delete.setOnClickListener(this)
        ligthDelete.setOnClickListener(this)
        plusminus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.one -> presenter.plusLine('1')
            R.id.two -> presenter.plusLine('2')
            R.id.three -> presenter.plusLine('3')
            R.id.four -> presenter.plusLine('4')
            R.id.five -> presenter.plusLine('5')
            R.id.six -> presenter.plusLine('6')
            R.id.seven -> presenter.plusLine('7')
            R.id.eight -> presenter.plusLine('8')
            R.id.nine -> presenter.plusLine('9')
            R.id.zero -> presenter.plusLine('0')
            R.id.dot -> presenter.plusLine('.')
            R.id.delete -> presenter.deleteAll()
           R.id.ligthDelete-> presenter.deleteLigth()
            R.id.result -> presenter.actionCalculate()
            R.id.plus -> presenter.plusLine('+')
            R.id.minus -> presenter.plusLine('-')
            R.id.multiply -> presenter.plusLine('*')
            R.id.divate -> presenter.plusLine('/')
            R.id.step -> presenter.plusLine('^')
            //     R.id.plusminus-> writeSing("2")

        }
    }

    override fun showTAsk() {
        var toast = Toast.makeText(this, "You can not do this", Toast.LENGTH_SHORT).show()
    }

}


