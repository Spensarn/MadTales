package com.example.spens.mad_lib_design_2

import android.content.Intent
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

    var array_desc_1 = arrayOf("Substantiv","Verb","Fordon","Sport","siffra","")
    var array_desc_2 = arrayOf("Namn","Siffra","skostorlek","siffra","")
    var textStory_test = spelare1 + ": Hej jag har en " + array_desc_1[0] + " gillar att " + array_desc_1[1] + " på en " + array_desc_1[2] + "\n" +
            spelare2 + ": Hejsan " + array_desc_2[0] + " heter jag och är " + array_desc_2[1] + "gammal och har " + array_desc_2[2] +" i skostorlek" + "\n" +
            spelare1 + ": Jaså vad kul " + array_desc_1[3] + " är vad jag sysslar med " + array_desc_1[4] + " gånger varje dag" + "\n" +
            spelare2 + ": Det gör jag också fast jag kör" + array_desc_2[3] + " gånger varje dag"

    var counter1 = 0
    var counter2 = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player_test)

        buttonEffect(nästa_button_test)






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

        fort.setOnClickListener {
            desc_test.visibility = View.VISIBLE
            vilken_spelare.visibility = View.VISIBLE
            input_nästa_test.visibility = View.VISIBLE
            nästa_button_test.visibility = View.VISIBLE
            desc_test.text = array_desc_2[0]
            vilken_spelare.text = spelare2
            counter1++
            counter2++
        }


        nästa_button_test.setOnClickListener {
            if (counter1 < array_desc_1.size) {
                Log.d("Signal","1")
                desc_test.text = array_desc_1[counter1]
                array_desc_1[counter1-1] = input_nästa_test.text.toString()
                counter1++
                textStory_test = spelare1 + ": Hej jag har en " + array_desc_1[0] + " gillar att " + array_desc_1[1] + " på en " + array_desc_1[2] + "\n" +
                        spelare2 + ": Hejsan " + array_desc_2[0] + " heter jag och är " + array_desc_2[1] + "gammal och har " + array_desc_2[2] +" i skostorlek" + "\n" +
                        spelare1 + ": Jaså vad kul " + array_desc_1[3] + " är vad jag sysslar med " + array_desc_1[4] + " gånger varje dag" + "\n" +
                        spelare2 + ": Det gör jag också fast jag kör" + array_desc_2[3] + " gånger varje dag"
                Log.d("Test",array_desc_1.size.toString())
                Log.d("Test",counter1.toString())
                input_nästa_test.setText("")

                /*if(counter1 == array_desc_1.size) {
                    Log.d("Signal","2")
                    desc_test.setText("Byt spelare")
                }*/

            }
            if(counter1 == array_desc_1.size) {
                fort.visibility = View.VISIBLE
                input_nästa_test.visibility = View.INVISIBLE
                vilken_spelare.text = spelare2 + "s tur"

            }


            if (counter1 > array_desc_1.size) {
                input_nästa_test.visibility = View.VISIBLE
                Log.d("Signal","2")
                vilken_spelare.text = spelare2
                desc_test.text = array_desc_2[counter2]
                array_desc_2[counter2-1] = input_nästa_test.text.toString()
                counter2++
                textStory_test = spelare1 + ": Hej jag har en " + array_desc_1[0] + " gillar att " + array_desc_1[1] + " på en " + array_desc_1[2] + "\n" +
                        spelare2 + ": Hejsan " + array_desc_2[0] + " heter jag och är " + array_desc_2[1] + "gammal och har " + array_desc_2[2] +" i skostorlek" + "\n" +
                        spelare1 + ": Jaså vad kul " + array_desc_1[3] + " är vad jag sysslar med " + array_desc_1[4] + " gånger varje dag" + "\n" +
                        spelare2 + ": Det gör jag också fast jag kör" + array_desc_2[3] + " gånger varje dag"
                input_nästa_test.setText("")

            }


            if(counter2 == array_desc_2.size){
                nästa_button_test.visibility = View.INVISIBLE
                input_nästa_test.visibility = View.INVISIBLE
                desc_test.visibility = View.INVISIBLE
                text_story.setText(textStory_test)
                array_desc_1 = arrayOf("Substantiv","Verb","Fordon","Sport","siffra","")
                array_desc_2 = arrayOf("Namn","Siffra","skostorlek","siffra","")


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
