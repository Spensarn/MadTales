package com.jacob.spens1.mad_lib_design_2

import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_choose_text.*

class choose_text : AppCompatActivity() {

    var bool: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_text)


        buttonEffect(presskonferens_button)
        buttonEffect(jobbintervju_button)
        buttonEffect(företagspitch_button)
        buttonEffect(bankrån_button)
        buttonEffect(kärleksbrev_button)
        buttonEffect(reklam_button)
        buttonEffect(nyheter_button)
        buttonEffect(matlagning_button)



        back_choose_text.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        presskonferens_button.setOnClickListener {
            val intent = Intent(this, presskonferens::class.java)
            startActivity(intent)
        }

        jobbintervju_button.setOnClickListener {
            val intent = Intent(this, jobbintervju::class.java)
            startActivity(intent)
        }
        bankrån_button.setOnClickListener {
            val intent = Intent(this, bankran::class.java)
            startActivity(intent)
        }
        företagspitch_button.setOnClickListener {
            val intent = Intent(this, foretagspitch::class.java)
            startActivity(intent)
        }

        kärleksbrev_button.setOnClickListener {
            val intent = Intent(this, karleksbrev::class.java)
            startActivity(intent)
        }

        reklam_button.setOnClickListener {
            val intent = Intent(this, reklam::class.java)
            startActivity(intent)
        }
        matlagning_button.setOnClickListener {
            val intent = Intent(this, matlagning::class.java)
            startActivity(intent)
        }

        nyheter_button.setOnClickListener {
            val intent = Intent(this, nyheter::class.java)
            startActivity(intent)
        }
    }
    fun buttonEffect(button: View) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(
                        resources.getColor(R.color.colorPrimaryDark),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }
    }
}


