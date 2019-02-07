package com.example.spens.mad_lib_design_2

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_two_player_test.*

class two_player_test : AppCompatActivity() {

    var spelare1 = ""
    var spelare2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player_test)

        buttonEffect(nästa_button_test)

        var array_desc_1 = arrayOf("Substantiv","Verb","Fordon","")
        var array_desc_2 = arrayOf("Namn","Siffra","skostorlek","")
        var textStory_test = spelare1 + ": Hej jag har en" + array_desc_1[0] + " gillar att" + array_desc_1[1] + " på en " + array_desc_1[2] + "\n" +
                spelare2 + ": Hejsan " + array_desc_2[0] + " heter jag och är " + array_desc_2[1] + "gammal och har " + array_desc_2[2] +"i skostorlek" + "\n" +
                spelare1 + "Jaså vad kul"

        var counter1 = 0
        var counter2 = 0

        spela_test.setOnClickListener {
            spelare1 = in_text_test.text.toString()
            spelare2 = in_text_test2.text.toString()
            in_text_test.visibility = View.INVISIBLE
            in_text_test2.visibility = View.INVISIBLE
            spela_test.visibility = View.INVISIBLE
            desc_test.visibility = View.VISIBLE
            vilken_spelare.visibility = View.VISIBLE
            input_nästa_test.visibility = View.VISIBLE
            nästa_button_test.visibility = View.VISIBLE
            vilken_spelare.text = spelare1
            desc_test.text = array_desc_1[0]
            counter1++
        }
        if(counter1 < array_desc_1.size) {
        nästa_button_test.setOnClickListener {
                desc_test.text = array_desc_1[counter1]
                array_desc_1[counter1 - 1] = input_nästa_test.text.toString()
                counter1++
                input_nästa_test.setText("")
            }
        }

        else if(counter2 < array_desc_2.size){
        nästa_button_test.setOnClickListener {
            desc_test.text = array_desc_2[counter2]
            array_desc_2[counter2-1] = input_nästa_test.text.toString()
            counter2++
            input_nästa_test.setText("")
            Log.d("Testar", "Test")
            }
        }


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
