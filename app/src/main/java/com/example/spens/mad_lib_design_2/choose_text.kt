package com.example.spens.mad_lib_design_2

import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        buttonEffect(jakt_button)
        buttonEffect(reklam_button)

        sticky_switch.setOnClickListener {
            if (bool == true) {
                Log.d("Testar", "1")
                bool = false
                presskonferens_button.visibility = View.INVISIBLE
                jobbintervju_button.visibility = View.INVISIBLE
                företagspitch_button.visibility = View.INVISIBLE
                bankrån_button.visibility = View.INVISIBLE
                jakt_button.visibility = View.INVISIBLE
                reklam_button.visibility = View.INVISIBLE
                spelarläge.setText("2 Spelare")


            } else {
                Log.d("Testar", "2")
                bool = true
                presskonferens_button.visibility = View.VISIBLE
                jobbintervju_button.visibility = View.VISIBLE
                företagspitch_button.visibility = View.VISIBLE
                bankrån_button.visibility = View.VISIBLE
                jakt_button.visibility = View.VISIBLE
                reklam_button.visibility = View.VISIBLE
                spelarläge.setText("1 Spelare")


            }
        }

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

        jakt_button.setOnClickListener {
            val intent = Intent(this, jakt::class.java)
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


