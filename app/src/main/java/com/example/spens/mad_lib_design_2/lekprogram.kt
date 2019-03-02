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
import kotlinx.android.synthetic.main.activity_lekprogram.*
import kotlinx.android.synthetic.main.activity_two_player_test.*

class lekprogram : AppCompatActivity() {

    var spelare1 = ""
    var spelare2 = ""
    var counter1 = 0
    var counter2 = 0

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lekprogram)

        random_generator.random_tips(tips_text_lekprogram)

        array_lekprogram_p2 = arrayOf("Påhittat namn","Stad","Tidsspann","Siffra","Valuta","Adjektiv","Känd person","Djur","Film","Teckand film","Siffra","Person i rummet","Årtal","Annat årtal","Elektronisk pryl","Hög siffra","Låg siffra","")
        array_lekprogram_p1 = arrayOf("Töntig hälsningsfras","Adjektiv","Något som är olagligt att köpa, i plural","Adjektiv","Farligt land","Tidsspann","Något man säger när man blir förvånad","Organ","Något man säger när man blir arg","Skriv 'ja' eller 'nej'","")

        spela_button_lekprogram.setOnClickListener {


            if(spelare1_lekprogram_input.text.isEmpty() || spelare2_lekprogram_input.text.isEmpty()){
                Toast.makeText(this, "Alla fälten ska var ifyllda!", Toast.LENGTH_SHORT).show()
            }else {

                spelare1 = spelare1_lekprogram_input.text.toString()
                spelare2 = spelare2_lekprogram_input.text.toString()
                spelare1_lekprogram_input.visibility = View.INVISIBLE
                tips_text_lekprogram.visibility = View.VISIBLE
                tips_title_lekprogram.visibility = View.VISIBLE
                spelare2_lekprogram_input.visibility = View.INVISIBLE
                spela_button_lekprogram.visibility = View.INVISIBLE
                desc_text_lekprogram.visibility = View.VISIBLE
                vilken_spelare_lekprogram.visibility = View.VISIBLE
                in_text_lekprogram.visibility = View.VISIBLE
                nästa_button_lekprogram.visibility = View.VISIBLE
                vilken_spelare_lekprogram.text = spelare1
                desc_text_lekprogram.text = array_lekprogram_p2[0]
                counter1++
            }
        }

        fortsätt_button_lekprogram.setOnClickListener {
            desc_text_lekprogram.visibility = View.VISIBLE
            tips_text_lekprogram.visibility = View.VISIBLE
            tips_title_lekprogram.visibility = View.VISIBLE
            byt_spelare_lekprogram.visibility = View.INVISIBLE
            vilken_spelare_lekprogram.text = spelare2
            vilken_spelare_lekprogram.visibility = View.VISIBLE
            in_text_lekprogram.visibility = View.VISIBLE
            nästa_button_lekprogram.visibility = View.VISIBLE
            desc_text_lekprogram.text = array_lekprogram_p1[0]
            vilken_spelare_lekprogram.text = spelare2
            fortsätt_button_lekprogram.visibility = View.INVISIBLE
            counter1++
            counter2++
        }


        nästa_button_lekprogram.setOnClickListener {
            if (counter1 < array_lekprogram_p2.size) {
                Log.d("Signal", "1")
                desc_text_lekprogram.text = array_lekprogram_p2[counter1]
                array_lekprogram_p2[counter1 - 1] = in_text_lekprogram.text.toString()
                counter1++
                textStory_lekprogram = spelare1 +": Hej och välkomna till kvällens program, idag har jag med mig "+ array_lekprogram_p2[0]+ " som kommer från "+ array_lekprogram_p2[1]+ " och är "+ array_lekprogram_p2[2]+ " gammal. Hur mår du? Är du Nervös? \n" +
                        spelare2 + ": "+ array_lekprogram_p1[0]+ " jag mår bra och känner mig "+ array_lekprogram_p1[1]+ " idag, är inte alls nervös faktiskt, känner att detta kommer gå bra.\n" +
                        spelare1 + ": Vad skulle du göra om du vann dessa "+ array_lekprogram_p2[3]+ " "+ array_lekprogram_p2[4] +"\n"+
                        spelare2 + ": Jag skulle nog köpa mig lite "+ array_lekprogram_p1[2]+ " och kanske en resa för mig och min "+ array_lekprogram_p1[3]+ " partner till "+ array_lekprogram_p1[4]+ ".\n"+
                        spelare1 + ": Okej då ska vi få se om du har vad som krävs för att bli…  "+ array_lekprogram_p2[5]+ ", här kommer första frågan. “I vilken film spelar "+ array_lekprogram_p2[6]+ " rollen som en "+ array_lekprogram_p2[7]+ "? Är det A: "+ array_lekprogram_p2[8]+ " eller B: "+ array_lekprogram_p2[9]+ "?\n"+
                        spelare2 + ": Oj ja denna är väldigt lätt! Såg faktiskt "+ array_lekprogram_p2[8]+ " för bara "+ array_lekprogram_p1[5]+ " sen, jag svarar alltså A "+ array_lekprogram_p2[8]+ "!\n"+
                        spelare1 + ": Det är rätt svar du har "+ array_lekprogram_p2[10]+ " " + array_lekprogram_p2[4]+ ". Nästa fråga följer “Vilket år föddes "+ array_lekprogram_p2[11]+ ", är det A: "+ array_lekprogram_p2[12]+ " eller B: "+ array_lekprogram_p2[13]+ "?\n"+
                        spelare2 + ": Oj den var svår, får nog ta och använda en livlina, jag frågar publiken.\n"+
                        spelare1 + ": Okej då ber vi publiken ta fram era "+ array_lekprogram_p2[14]+ " och svara… "+ array_lekprogram_p2[15]+ " procent svarade A och "+ array_lekprogram_p2[16]+ " svarade B.\n"+
                        spelare2 + ": "+ array_lekprogram_p1[6]+ " nu blir jag osäker, men jag måste lita på min "+ array_lekprogram_p1[7]+ " känsla och säga B.\n" +
                        spelare1 + ": Det är tyvärr fel och du är ute, tack för att du spelade! Var det kul?\n"+
                        spelare2 + ": "+ array_lekprogram_p1[8]+ " "+ array_lekprogram_p1[9]+ ".\n"+
                        spelare1 + ": Okej det var allt för ikväll vi ses nästa vecka, hejdå!"

                Log.d("Test", array_lekprogram_p2.size.toString())
                Log.d("Test", counter1.toString())
                in_text_lekprogram.setText("")

                /*if(counter1 == array_desc_1.size) {
                Log.d("Signal","2")
                desc_test.setText("Byt spelare")
            }*/

            }
            if (counter1 == array_lekprogram_p2.size) {
                fortsätt_button_lekprogram.visibility = View.VISIBLE
                byt_spelare_lekprogram.visibility = View.VISIBLE
                tips_text_lekprogram.visibility = View.INVISIBLE
                tips_title_lekprogram.visibility = View.INVISIBLE
                in_text_lekprogram.visibility = View.INVISIBLE
                nästa_button_lekprogram.visibility = View.INVISIBLE
                vilken_spelare_lekprogram.text = spelare2 + "s tur"

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
            }


            if (counter1 > array_lekprogram_p2.size) {
                in_text_lekprogram.visibility = View.VISIBLE
                fortsätt_button_lekprogram.visibility = View.INVISIBLE
                tips_text_lekprogram.visibility = View.VISIBLE
                tips_title_lekprogram.visibility = View.VISIBLE
                Log.d("Signal", "2")
                vilken_spelare_lekprogram.text = spelare2
                desc_text_lekprogram.text = array_lekprogram_p1[counter2]
                array_lekprogram_p1[counter2 - 1] = in_text_lekprogram.text.toString()
                counter2++
                textStory_lekprogram = spelare1 +": Hej och välkomna till kvällens program, idag har jag med mig "+ array_lekprogram_p2[0]+ " som kommer från "+ array_lekprogram_p2[1]+ " och är "+ array_lekprogram_p2[2]+ " gammal. Hur mår du? Är du Nervös? \n" +
                        spelare2 + ": "+ array_lekprogram_p1[0]+ " jag mår bra och känner mig "+ array_lekprogram_p1[1]+ " idag, är inte alls nervös faktiskt, känner att detta kommer gå bra\n." +
                        spelare1 + ": Vad skulle du göra om du vann dessa "+ array_lekprogram_p2[3]+ " "+ array_lekprogram_p2[4] +"\n"+
                        spelare2 + ": Jag skulle nog köpa mig lite "+ array_lekprogram_p1[2]+ " och kanske en resa för mig och min "+ array_lekprogram_p1[3]+ " partner till "+ array_lekprogram_p1[4]+ ".\n"+
                        spelare1 + ": Okej då ska vi få se om du har vad som krävs för att bli…  "+ array_lekprogram_p2[5]+ ", här kommer första frågan. “I vilken film spelar "+ array_lekprogram_p2[6]+ " rollen som en "+ array_lekprogram_p2[7]+ "? Är det A: "+ array_lekprogram_p2[8]+ " eller B: "+ array_lekprogram_p2[9]+ "?\n"+
                        spelare2 + ": Oj ja denna är väldigt lätt! Såg faktiskt "+ array_lekprogram_p2[8]+ " för bara "+ array_lekprogram_p1[5]+ " sen, jag svarar alltså A "+ array_lekprogram_p2[8]+ "!\n"+
                        spelare1 + ": Det är rätt svar du har "+ array_lekprogram_p2[10]+ " " + array_lekprogram_p2[4]+ ". Nästa fråga följer “Vilket år föddes "+ array_lekprogram_p2[11]+ ", är det A: "+ array_lekprogram_p2[12]+ " eller B: "+ array_lekprogram_p2[13]+ "?\n"+
                        spelare2 + ": Oj den var svår, får nog ta och använda en livlina, jag frågar publiken.\n"+
                        spelare1 + ": Okej då ber vi publiken ta fram era "+ array_lekprogram_p2[14]+ " och svara… "+ array_lekprogram_p2[15]+ " procent svarade A och "+ array_lekprogram_p2[16]+ " svarade B.\n"+
                        spelare2 + ": "+ array_lekprogram_p1[6]+ " nu blir jag osäker, men jag måste lita på min "+ array_lekprogram_p1[7]+ " känsla och säga B\n." +
                        spelare1 + ": Det är tyvärr fel och du är ute, tack för att du spelade! Var det kul?\n"+
                        spelare2 + ": "+ array_lekprogram_p1[8]+ " "+ array_lekprogram_p1[9]+ ".\n"+
                        spelare1 + ": Okej det var allt för ikväll vi ses nästa vecka, hejdå!"

                in_text_lekprogram.setText("")

            }

            if (counter2 == array_lekprogram_p1.size) {
                nästa_button_lekprogram.visibility = View.INVISIBLE
                tips_title_lekprogram.visibility = View.INVISIBLE
                tips_text_lekprogram.visibility = View.INVISIBLE
                in_text_lekprogram.visibility = View.INVISIBLE
                desc_text_lekprogram.visibility = View.INVISIBLE
                vilken_spelare_lekprogram.visibility = View.INVISIBLE
                text_story_lekprogram.setText(textStory_lekprogram)
                array_lekprogram_p2 = arrayOf("Påhittat namn","Stad","Tidsspann","Siffra","Valuta","Adjektiv","Känd person","Djur","Film","Teckand film","Siffra","Person i rummet","Årtal","Annat årtal","Elektronisk pryl","Hög siffra","Låg siffra","")
                array_lekprogram_p1 = arrayOf("Töntig hälsningsfras","Adjektiv","Något som är olagligt att köpa, i plural","Adjektiv","Farligt land","Tidsspann","Något man säger när man blir förvånad","Organ","Något man säger när man blir arg","Skriv 'ja' eller 'nej'","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)
            }
        }
        back_button_lekprogram.setOnClickListener {
            array_lekprogram_p2 = arrayOf("Påhittat namn","Stad","Tidsspann","Siffra","Valuta","Adjektiv","Känd person","Djur","Film","Teckand film","Siffra","Person i rummet","Årtal","Annat årtal","Elektronisk pryl","Hög siffra","Låg siffra","")
            array_lekprogram_p1 = arrayOf("Töntig hälsningsfras","Adjektiv","Något som är olagligt att köpa, i plural","Adjektiv","Farligt land","Tidsspann","Något man säger när man blir förvånad","Organ","Något man säger när man blir arg","Skriv 'ja' eller 'nej'","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@lekprogram.finish() })
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

