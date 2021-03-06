package com.jacob.spens1.mad_lib_design_2

import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_choose_text2.*

class choose_text2 : AppCompatActivity() {

    var bool: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_text2)

        back_b.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        presskonferens_b.setOnClickListener {
            val intent = Intent(this, presskonferens::class.java)
            startActivity(intent)
        }

        jobbintervju_b.setOnClickListener {
            val intent = Intent(this, jobbintervju::class.java)
            startActivity(intent)
        }
        bankrån_b.setOnClickListener {
            val intent = Intent(this, bankran::class.java)
            startActivity(intent)
        }
        företagspitch_b.setOnClickListener {
            val intent = Intent(this, foretagspitch::class.java)
            startActivity(intent)
        }

        kärleksbrev_b.setOnClickListener {
            val intent = Intent(this, karleksbrev::class.java)
            startActivity(intent)
        }

        reklam_b.setOnClickListener {
            val intent = Intent(this, reklam::class.java)
            startActivity(intent)
        }
        matlagning_b.setOnClickListener {
            val intent = Intent(this, matlagning::class.java)
            startActivity(intent)
        }

        nyheter_b.setOnClickListener {
            val intent = Intent(this, nyheter::class.java)
            startActivity(intent)
        }
    }
    fun buttonEffect(Imagebutton: View) {
        Imagebutton.setOnTouchListener { v, event ->
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


