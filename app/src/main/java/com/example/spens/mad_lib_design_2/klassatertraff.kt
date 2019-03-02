package com.example.spens.mad_lib_design_2

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dejt.*
import kotlinx.android.synthetic.main.activity_klassatertraff.*
import kotlinx.android.synthetic.main.activity_two_player_test.*

class klassatertraff : AppCompatActivity() {

    var spelare1 = ""
    var spelare2 = ""
    var counter1 = 0
    var counter2 = 0


    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klassatertraff)

        random_generator.random_tips(tips_text_klass)

        array_klass_p2 = arrayOf("Något du säger när du blir förvånad","Sjukdom","Namn","Typ av straff i plural","Påhittat jobb","Substantiv i best form","Siffra","Djur","Verb","Ovanlig fritidsaktivitet","")
        array_klass_p1 = arrayOf("Jobb ett barn skulle vilja ha","Siffra","Siffra","Namn på elak person","Adjektiv","Olaglig aktivitet","Elaktronisk pryl som slutar på: n","Verb","")

        spela_button_klass.setOnClickListener {


            if(spelare1_klass_input.text.isEmpty() || spelare2_klass_input.text.isEmpty()){
                Toast.makeText(this, "Alla fälten ska var ifyllda!", Toast.LENGTH_SHORT).show()
            }else {

                beskrivning_klass.visibility = View.INVISIBLE
                spelare1 = spelare1_klass_input.text.toString()
                spelare2 = spelare2_klass_input.text.toString()
                spelare1_klass_input.visibility = View.INVISIBLE
                tips_text_klass.visibility = View.VISIBLE
                tips_title_klass.visibility = View.VISIBLE
                spelare2_klass_input.visibility = View.INVISIBLE
                spela_button_klass.visibility = View.INVISIBLE
                desc_text_klass.visibility = View.VISIBLE
                vilken_spelare_klass.visibility = View.VISIBLE
                in_text_klass.visibility = View.VISIBLE
                nästa_button_klass.visibility = View.VISIBLE
                vilken_spelare_klass.text = spelare1
                desc_text_klass.text = array_klass_p2[0]
                counter1++
            }
        }

        fortsätt_button_klass.setOnClickListener {
            desc_text_klass.visibility = View.VISIBLE
            tips_text_klass.visibility = View.VISIBLE
            tips_title_klass.visibility = View.VISIBLE
            byt_spelare_klass.visibility = View.INVISIBLE
            vilken_spelare_klass.text = spelare2
            vilken_spelare_klass.visibility = View.VISIBLE
            in_text_klass.visibility = View.VISIBLE
            nästa_button_klass.visibility = View.VISIBLE
            desc_text_klass.text = array_klass_p1[0]
            vilken_spelare_klass.text = spelare2
            fortsätt_button_klass.visibility = View.INVISIBLE
            counter1++
            counter2++
        }


        nästa_button_klass.setOnClickListener {
            if (counter1 < array_klass_p2.size) {
                Log.d("Signal", "1")
                desc_text_klass.text = array_klass_p2[counter1]
                array_klass_p2[counter1 - 1] = in_text_klass.text.toString()
                counter1++
                textStory_klass = spelare1 + ": Ne men " + com.example.spens.mad_lib_design_2.array_klass_p2[0] + " hej på dig! Det var inte igår! \n " +
                        spelare2 +": Hej " + klass_class.spelare1 + " ne det var det inte, hur är det?\n " +
                        spelare1 +": Jo förutom att jag har fått " + com.example.spens.mad_lib_design_2.array_klass_p2[1] + ", " + com.example.spens.mad_lib_design_2.array_klass_p2[2] + " har gjort slut med mig och jag har fått " + com.example.spens.mad_lib_design_2.array_klass_p2[3] + " så är allt bra. Själv?\n " +
                        spelare2 +": Ne allt är bra för mig, jag jobbar fortfarande som " + com.example.spens.mad_lib_design_2.array_klass_p1[0] + ", är inne på mitt " + com.example.spens.mad_lib_design_2.array_klass_p1[1] + "e år nu.\n "+
                        spelare1 +": Vad kul! Ne jag har fått nytt jobb som " + com.example.spens.mad_lib_design_2.array_klass_p2[4] + ", det är inte jättekul men jag tjänar bra, vi har lite annat system där, lönen man får är " + com.example.spens.mad_lib_design_2.array_klass_p2[5] + ".\n "+
                        spelare2 +": Ehm okej, ja det låter ju bra, jag och min partner har faktiskt skaffat barn, eller rättare sagt " + com.example.spens.mad_lib_design_2.array_klass_p1[2] + " stycken, vårt senaste heter " + com.example.spens.mad_lib_design_2.array_klass_p1[3] + " och är väldigt " + com.example.spens.mad_lib_design_2.array_klass_p1[4] + ".\n" +
                        spelare1 +": Jaha vad kul! Själv har man ju bara sina " + com.example.spens.mad_lib_design_2.array_klass_p2[6] + " stycken " + com.example.spens.mad_lib_design_2.array_klass_p2[7] + " hemma, men så kan det va, hoppas man kan hitta någon trevlig person och " + com.example.spens.mad_lib_design_2.array_klass_p2[8] + " på snart.\n"+
                        spelare2 +": Ja men det gör du nog! Kommer ihåg att du höll mycket på med " + com.example.spens.mad_lib_design_2.array_klass_p1[5] + " på fritiden, gör du fortfarande det?\n"+
                        spelare1 +": Nja jag har slutat, har börjat att " + com.example.spens.mad_lib_design_2.array_klass_p2[9] + ", det är ganska kul! Vad gör du när du får lite ledig tid?\n"+
                        spelare2 +": Jag sitter bara framför " + com.example.spens.mad_lib_design_2.array_klass_p1[6] + " hela dagarna så inget intressant, men jag måste iväg nu och " + com.example.spens.mad_lib_design_2.array_klass_p1[7] + " så vi får höras senare\n!"+
                        spelare1 + ": Okej ha det!"

                Log.d("Test", array_klass_p2.size.toString())
                Log.d("Test", counter1.toString())
                in_text_klass.setText("")

                /*if(counter1 == array_desc_1.size) {
                Log.d("Signal","2")
                desc_test.setText("Byt spelare")
            }*/

            }
            if (counter1 == array_klass_p2.size) {
                fortsätt_button_klass.visibility = View.VISIBLE
                byt_spelare_klass.visibility = View.VISIBLE
                tips_text_klass.visibility = View.INVISIBLE
                tips_title_klass.visibility = View.INVISIBLE
                in_text_klass.visibility = View.INVISIBLE
                nästa_button_klass.visibility = View.INVISIBLE
                vilken_spelare_klass.text = spelare2 + "s tur"

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
            }


            if (counter1 > array_klass_p2.size) {
                in_text_klass.visibility = View.VISIBLE
                fortsätt_button_klass.visibility = View.INVISIBLE
                tips_text_klass.visibility = View.VISIBLE
                tips_title_klass.visibility = View.VISIBLE
                Log.d("Signal", "2")
                vilken_spelare_klass.text = spelare2
                desc_text_klass.text = array_klass_p1[counter2]
                array_klass_p1[counter2 - 1] = in_text_klass.text.toString()
                counter2++
                textStory_klass = spelare1 + ": Ne men " + com.example.spens.mad_lib_design_2.array_klass_p2[0] + " hej på dig! Det var inte igår! \n " +
                        spelare2 +": Hej " + klass_class.spelare1 + " ne det var det inte, hur är det?\n " +
                        spelare1 +": Jo förutom att jag har fått " + com.example.spens.mad_lib_design_2.array_klass_p2[1] + ", " + com.example.spens.mad_lib_design_2.array_klass_p2[2] + " har gjort slut med mig och jag har fått " + com.example.spens.mad_lib_design_2.array_klass_p2[3] + " så är allt bra. Själv?\n " +
                        spelare2 +": Ne allt är bra för mig, jag jobbar fortfarande som " + com.example.spens.mad_lib_design_2.array_klass_p1[0] + ", är inne på mitt " + com.example.spens.mad_lib_design_2.array_klass_p1[1] + "e år nu.\n "+
                        spelare1 +": Vad kul! Ne jag har fått nytt jobb som " + com.example.spens.mad_lib_design_2.array_klass_p2[4] + ", det är inte jättekul men jag tjänar bra, vi har lite annat system där, lönen man får är " + com.example.spens.mad_lib_design_2.array_klass_p2[5] + ".\n "+
                        spelare2 +": Ehm okej, ja det låter ju bra, jag och min partner har faktiskt skaffat barn, eller rättare sagt " + com.example.spens.mad_lib_design_2.array_klass_p1[2] + " stycken, vårt senaste heter " + com.example.spens.mad_lib_design_2.array_klass_p1[3] + " och är väldigt " + com.example.spens.mad_lib_design_2.array_klass_p1[4] + ".\n" +
                        spelare1 +": Jaha vad kul! Själv har man ju bara sina " + com.example.spens.mad_lib_design_2.array_klass_p2[6] + " stycken " + com.example.spens.mad_lib_design_2.array_klass_p2[7] + " hemma, men så kan det va, hoppas man kan hitta någon trevlig person och " + com.example.spens.mad_lib_design_2.array_klass_p2[8] + " på snart.\n"+
                        spelare2 +": Ja men det gör du nog! Kommer ihåg att du höll mycket på med " + com.example.spens.mad_lib_design_2.array_klass_p1[5] + " på fritiden, gör du fortfarande det?\n"+
                        spelare1 +": Nja jag har slutat, har börjat att " + com.example.spens.mad_lib_design_2.array_klass_p2[9] + ", det är ganska kul! Vad gör du när du får lite ledig tid?\n"+
                        spelare2 +": Jag sitter bara framför " + com.example.spens.mad_lib_design_2.array_klass_p1[6] + " hela dagarna så inget intressant, men jag måste iväg nu och " + com.example.spens.mad_lib_design_2.array_klass_p1[7] + " så vi får höras senare\n!"+
                        spelare1 + ": Okej ha det!"

                in_text_klass.setText("")

            }

            if (counter2 == array_klass_p1.size) {
                nästa_button_klass.visibility = View.INVISIBLE
                beskrivning_klass.visibility = View.INVISIBLE
                tips_title_klass.visibility = View.INVISIBLE
                tips_text_klass.visibility = View.INVISIBLE
                in_text_klass.visibility = View.INVISIBLE
                desc_text_klass.visibility = View.INVISIBLE
                vilken_spelare_klass.visibility = View.INVISIBLE
                text_story_klass.setText(textStory_klass)
                array_klass_p2 = arrayOf("Något du säger när du blir förvånad","Sjukdom","Namn","Typ av straff i plural","Påhittat jobb","Substantiv i best form","Siffra","Djur","Verb","Ovanlig fritidsaktivitet","")
                array_klass_p1 = arrayOf("Jobb ett barn skulle vilja ha","Siffra","Siffra","Namn på elak person","Adjektiv","Olaglig aktivitet","Elaktronisk pryl som slutar på: n","Verb","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
            }
        }
        back_button_klass.setOnClickListener {
            array_klass_p2 = arrayOf("Något du säger när du blir förvånad","Sjukdom","Namn","Typ av straff i plural","Påhittat jobb","Substantiv i best form","Siffra","Djur","Verb","Ovanlig fritidsaktivitet","")
            array_klass_p1 = arrayOf("Jobb ett barn skulle vilja ha","Siffra","Siffra","Namn på elak person","Adjektiv","Olaglig aktivitet","Elaktronisk pryl som slutar på: n","Verb","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@klassatertraff.finish() })
                .setNegativeButton("Nej", null)
                .show()
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
