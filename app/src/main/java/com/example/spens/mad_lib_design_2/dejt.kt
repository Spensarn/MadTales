package com.example.spens.mad_lib_design_2

import android.app.Activity
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
import kotlinx.android.synthetic.main.activity_two_player_test.*

class dejt : AppCompatActivity() {

    var spelare1 = ""
    var spelare2 = ""
    var counter1 = 0
    var counter2 = 0

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dejt)

        random_generator.random_tips(tips_text_dejt)

        array_dejt_p2 = arrayOf("Adjektiv","Verb som slutar på: a","Resturang","Siffra","Längenhet","Adjektiv","Siffra","Substantiv i plural","Kroppsdel som sluar på: t","")
        array_dejt_p1 = arrayOf("Fordon i best form","Substantiv","Klädesplagg i best form","Vätska","Adjektiv som kan beskriva mat","Land","Star Wars karaktär","Substantiv","Tecknad figur","")

            spela_button_dejt.setOnClickListener {


                if(spelare1_dejt_input.text.isEmpty() || spelare2_dejt_input.text.isEmpty()){
                    Toast.makeText(this, "Alla fälten ska var ifyllda!", Toast.LENGTH_SHORT).show()
                }else {

                    beskrivning_dejt.visibility = View.INVISIBLE
                    spelare1 = spelare1_dejt_input.text.toString()
                    spelare2 = spelare2_dejt_input.text.toString()
                    spelare1_dejt_input.visibility = View.INVISIBLE
                    tips_text_dejt.visibility = View.VISIBLE
                    tips_title_dejt.visibility = View.VISIBLE
                    spelare2_dejt_input.visibility = View.INVISIBLE
                    spela_button_dejt.visibility = View.INVISIBLE
                    desc_text_dejt.visibility = View.VISIBLE
                    vilken_spelare_dejt.visibility = View.VISIBLE
                    in_text_dejt.visibility = View.VISIBLE
                    nästa_button_dejt.visibility = View.VISIBLE
                    vilken_spelare_dejt.text = spelare1
                    desc_text_dejt.text = array_dejt_p2[0]
                    counter1++
                }
            }

            fortsätt_button_dejt.setOnClickListener {
                desc_text_dejt.visibility = View.VISIBLE
                tips_text_dejt.visibility = View.VISIBLE
                tips_title_dejt.visibility = View.VISIBLE
                byt_spelare_dejt.visibility = View.INVISIBLE
                vilken_spelare_dejt.text = spelare2
                vilken_spelare_dejt.visibility = View.VISIBLE
                in_text_dejt.visibility = View.VISIBLE
                nästa_button_dejt.visibility = View.VISIBLE
                desc_text_dejt.text = array_dejt_p1[0]
                vilken_spelare_dejt.text = spelare2
                fortsätt_button_dejt.visibility = View.INVISIBLE
                counter1++
                counter2++
            }


            nästa_button_dejt.setOnClickListener {
                if (counter1 < array_dejt_p2.size) {
                    Log.d("Signal", "1")
                    desc_text_dejt.text = array_dejt_p2[counter1]
                    array_dejt_p2[counter1 - 1] = in_text_dejt.text.toString()
                    counter1++
                    textStory_dejt = " "+ spelare1+ ": Hej! trevligt att träffas! " + spelare2 + " var det va? Jag heter " + spelare1 + ", vad sägs som att gå in?\n" +
                            " "+ spelare2 + ": Hej, ja det låter bra, förlåt om jag var lite sen, men på vägen till "+ array_dejt_p1[0] + " kom jag på att jag hade glömt min "+ array_dejt_p1[1] + ", och behöver verkligen den ikväll.\n" +
                            spelare1 + ": Ingen fara, du ser väldigt "+ array_dejt_p2[0] + " ut ikväll! När jag väntade på dig passade jag på att "+ array_dejt_p2[1] + " lite för att få bort nerverna, är faktiskt lite nervös inför den här dejten.\n" +
                            spelare2 + ": Jag är också lite nervös, men detta ska bli kul, köpte faktiskt den här "+ array_dejt_p1[2] + " bara för ikväll. Jag tycker vi går till restaurangen nu, börjar bli kallt här ute\n" +
                            spelare1 + ": Ja självklart. Har bokat bord på "+ array_dejt_p2[2] + ", tänkte att vi skulle slå på stort ikväll. Det är inte så långt, ligger bara "+ array_dejt_p2[3]+ " " + array_dejt_p2[4] + " härifrån.\n" +
                            spelare2 + ": Oj vilken fin restaurang, har aldrig varit här förut. Ska vi beställa något att dricka? Jag tar gärna ett glas "+ array_dejt_p1[3] + ".\n" +
                            spelare1 + ": Det låter "+ array_dejt_p2[5] + "t, tar nog också det. Så... berätta lite om dig själv? \n" +
                            spelare2 + ": Jag kommer från "+ array_dejt_p1[5] + ", min pappa är "+ array_dejt_p1[6] + " men jag känner inte min mamma. Jag gillar att samla på "+ array_dejt_p1[7] + " och jobbar som assistent åt "+ array_dejt_p1[8] + ".\n" +
                            "Person 1: Då har vi ett problem, jag har nämligen besöksförbud minst "+ array_dejt_p2[6] + " meter ifrån "+ array_dejt_p1[8] + " efter att jag kastade några "+ array_dejt_p2[7] + " och bröt "+ array_dejt_p2[8] + " på stackaren efter en dålig dejt vi hade. Så jag tror jag får lov att säga hejdå, detta kommer nog inte funka mellan oss."

                    Log.d("Test", array_dejt_p2.size.toString())
                    Log.d("Test", counter1.toString())
                    in_text_dejt.setText("")

                    /*if(counter1 == array_desc_1.size) {
                    Log.d("Signal","2")
                    desc_test.setText("Byt spelare")
                }*/

                }
                if (counter1 == array_dejt_p2.size) {
                    fortsätt_button_dejt.visibility = View.VISIBLE
                    byt_spelare_dejt.visibility = View.VISIBLE
                    tips_text_dejt.visibility = View.INVISIBLE
                    tips_title_dejt.visibility = View.INVISIBLE
                    in_text_dejt.visibility = View.INVISIBLE
                    nästa_button_dejt.visibility = View.INVISIBLE
                    vilken_spelare_dejt.text = spelare2 + "s tur"

                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
                }


                if (counter1 > array_dejt_p2.size) {
                    in_text_dejt.visibility = View.VISIBLE
                    fortsätt_button_dejt.visibility = View.INVISIBLE
                    tips_text_dejt.visibility = View.VISIBLE
                    tips_title_dejt.visibility = View.VISIBLE
                    Log.d("Signal", "2")
                    vilken_spelare_dejt.text = spelare2
                    desc_text_dejt.text = array_dejt_p1[counter2]
                    array_dejt_p1[counter2 - 1] = in_text_dejt.text.toString()
                    counter2++
                    textStory_dejt = " "+ spelare1+ ": Hej! trevligt att träffas! " + spelare2 + " var det va? Jag heter " + spelare1 + ", vad sägs som att gå in?\n" +
                            " "+ spelare2 + ": Hej, ja det låter bra, förlåt om jag var lite sen, men på vägen till "+ array_dejt_p1[0] + " kom jag på att jag hade glömt min "+ array_dejt_p1[1] + ", och behöver verkligen den ikväll.\n " +
                            spelare1+ ": Ingen fara, du ser väldigt "+ array_dejt_p2[0] + " ut ikväll! När jag väntade på dig passade jag på att "+ array_dejt_p2[1] + " lite för att få bort nerverna, är faktiskt lite nervös inför den här dejten.\n " +
                            spelare2+ ": Jag är också lite nervös, men detta ska bli kul, köpte faktiskt den här "+ array_dejt_p1[2] + " bara för ikväll. Jag tycker vi går till restaurangen nu, börjar bli kallt här ute\n " +
                            spelare1+ ": Ja självklart. Har bokat bord på "+ array_dejt_p2[2] + ", tänkte att vi skulle slå på stort ikväll. Det är inte så långt, ligger bara "+ array_dejt_p2[3]+ " " + array_dejt_p2[4] + " härifrån.\n" +
                            spelare2+ ": Oj vilken fin restaurang, har aldrig varit här förut. Ska vi beställa något att dricka? Jag tar gärna ett glas "+ array_dejt_p1[3] + ".\n " +
                            spelare1+ ": Det låter "+ array_dejt_p2[5] + "t, tar nog också det. Så... berätta lite om dig själv? \n " +
                            spelare2+ ": Jag kommer från "+ array_dejt_p1[5] + ", min pappa är "+ array_dejt_p1[6] + " men jag känner inte min mamma. Jag gillar att samla på "+ array_dejt_p1[7] + " och jobbar som assistent åt "+ array_dejt_p1[8] + ".\n" +
                            spelare1+" : Då har vi ett problem, jag har nämligen besöksförbud minst "+ array_dejt_p2[6] + " meter ifrån "+ array_dejt_p1[8] + " efter att jag kastade några "+ array_dejt_p2[7] + " och bröt "+ array_dejt_p2[8] + " på stackaren efter en dålig dejt vi hade. Så jag tror jag får lov att säga hejdå, detta kommer nog inte funka mellan oss."
                    in_text_dejt.setText("")

                }

                if (counter2 == array_dejt_p1.size) {
                    nästa_button_dejt.visibility = View.INVISIBLE
                    beskrivning_dejt.visibility = View.INVISIBLE
                    tips_title_dejt.visibility = View.INVISIBLE
                    tips_text_dejt.visibility = View.INVISIBLE
                    in_text_dejt.visibility = View.INVISIBLE
                    desc_text_dejt.visibility = View.INVISIBLE
                    vilken_spelare_dejt.visibility = View.INVISIBLE
                    text_story_dejt.setText(textStory_dejt)
                    array_dejt_p2 = arrayOf("Adjektiv","Verb som slutar på: a","Resturang","Siffra","Längenhet","Adjektiv","Siffra","Substantiv i plural","Kroppsdel som sluar på: t","")
                    array_dejt_p1 = arrayOf("Fordon i best form","Substantiv","Klädesplagg i best form","Vätska","Adjektiv som kan beskriva mat","Land","Star Wars karaktär","Substantiv","Tecknad figur","")

                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
                }
            }
        back_button_dejt.setOnClickListener {
            array_dejt_p2 = arrayOf("Adjektiv","Verb som slutar på: a","Resturang","Siffra","Längenhet","Adjektiv","Siffra","Substantiv i plural","Kroppsdel som sluar på: t","")
            array_dejt_p1 = arrayOf("Fordon i best form","Substantiv","Klädesplagg i best form","Vätska","Adjektiv som kan beskriva mat","Land","Star Wars karaktär","Substantiv","Tecknad figur","")
            val intent = Intent(this, choose_text::class.java)
            startActivity(intent)
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
