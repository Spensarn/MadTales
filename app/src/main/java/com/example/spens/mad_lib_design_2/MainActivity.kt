package com.example.spens.mad_lib_design_2

import android.app.Dialog
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var btn: ImageButton
    lateinit var myDialog: Dialog
    lateinit var back: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buttonEffect(start)

        start.setOnClickListener {
            val intent = Intent(this, choose_text2::class.java)
            startActivity(intent)
        }


        btn = findViewById<View>(R.id.hur_man_spelar) as ImageButton
        btn.setOnClickListener {
            ShowDialog_1()
        }

        btn = findViewById<View>(R.id.om_spelet) as ImageButton
        btn.setOnClickListener {
            ShowDialog_2()
        }
    }

    fun ShowDialog_1() {
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.hur_man_spelar)

        back = myDialog.findViewById<View>(R.id.back_button_card_1) as ImageButton
        back.isEnabled = true
        back.setOnClickListener {
            myDialog.cancel()
        }
        myDialog.show()
    }
    fun ShowDialog_2(){
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.om_spelet)

        back = myDialog.findViewById<View>(R.id.back_card_2) as ImageButton
        back.isEnabled = true
        back.setOnClickListener {
            myDialog.cancel()
        }
        myDialog.show()

    }

    fun buttonEffect(button: View) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(resources.getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP)
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

