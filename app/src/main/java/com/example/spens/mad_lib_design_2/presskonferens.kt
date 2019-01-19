package com.example.spens.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_presskonferens.*

class presskonferens : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presskonferens)


        back_button_presskonferns.setOnClickListener {
            array_presskonferens = arrayOf("Namn på en tecknad figur", "Tidsenhet", "Beskrivning på en person","Siffra", "Mätenhet", "Färg","Siffra","Tidsenhet","Geografisk plats", "Substantiv", "Kroppsdel","Namn på känd person","Högtid","Årtal","Namn på känd plats", "Substantiv i singular", "Kroppsdel i best.form","Siffra","Historisk person", "Resturang", "Siffra","Tidsenhet","")
            val intent = Intent(this, choose_text::class.java)
            startActivity(intent)

        }

        var counter_presskonferens = 0

        spela_button_presskonferns.setOnClickListener {
            input_text_presskonferns.visibility = View.VISIBLE
            confirm_button_presskonferns.visibility = View.VISIBLE
            spela_button_presskonferns.visibility = View.INVISIBLE
            desc_text_presskonferns.setText(array_presskonferens[counter_presskonferens])
            counter_presskonferens++
        }

        confirm_button_presskonferns.setOnClickListener {
            if (counter_presskonferens < array_presskonferens.size) {
                desc_text_presskonferns.setText(array_presskonferens[counter_presskonferens])
                array_presskonferens[counter_presskonferens - 1] = input_text_presskonferns.getText().toString()
                counter_presskonferens++
                textStory_presskonferens = "God kväll, jag heter " + array_presskonferens[0] + " och är huvudansvarig för denna mordutredning. Jag och mitt team har arbetat i många " + array_presskonferens[1] + " för att få fram en " + array_presskonferens[2] + " och bra beskrivning på mördaren. Det vi i nuläget vet är att mördaren antagligen är " + array_presskonferens[3] + " " + array_presskonferens[4] + " lång, har " + array_presskonferens[5] + " hårfärg, är cirka " + array_presskonferens[6] + " " + array_presskonferens[7] + " gammal, bor i " + array_presskonferens[8] + " och har av vittnen blivit sedd ha en " + array_presskonferens[9] + " hängandes kring sin " + array_presskonferens[10] + ". Vi har kommit fram till att mordet på " + array_presskonferens[11] + " ägt rum på " + array_presskonferens[12] + " " + array_presskonferens[13] + ". Brottet skedde i " + array_presskonferens[14] + ". Vapnet som mördaren ska ha använt var en/ett " + array_presskonferens[15] + ". Vapnet ska ha använts på så sätt att mördaren slog offret 10 gånger på " + array_presskonferens[16] + " vilket tillslut ledde till offrets död. Vi har just nu " + array_presskonferens[17] + " bevis som pekar på att brottet har begåtts av " + array_presskonferens[18] + ". Dock behöver vi ännu mer bevis för att vara säkra. Vi har ännu inte hittat brottslingen men enligt en trovärdig källa besöker mördaren " + array_presskonferens[19] + " " + array_presskonferens[20] + " gånger varje " + array_presskonferens[21] + ". Så vi räknar med ett gripande inom kort. Tack för mig!"
                input_text_presskonferns.setText("")


            }
            else {
                counter_presskonferens++
            }

            if (counter_presskonferens == array_presskonferens.size) {
                text_story_presskonferns.setText(textStory_presskonferens)
                desc_text_presskonferns.visibility = View.INVISIBLE
                confirm_button_presskonferns.visibility = View.INVISIBLE
                input_text_presskonferns.visibility = View.INVISIBLE
                array_presskonferens = arrayOf("Namn på en tecknad figur", "Tidsenhet", "Beskrivning på en person","Siffra", "Mätenhet", "Färg","Siffra","Tidsenhet","Geografisk plats", "Substantiv", "Kroppsdel","Namn på känd person","Högtid","Årtal","Namn på känd plats", "Substantiv i singular", "Kroppsdel i best.form","Siffra","Historisk person", "Resturang", "Siffra","Tidsenhet","")

            }

        }

    }
}
