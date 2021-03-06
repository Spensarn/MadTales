package com.jacob.spens1.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_bankran.*
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.PorterDuff
import android.view.MotionEvent


class bankran : AppCompatActivity() {


val random_generator = com.jacob.spens1.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bankran)
        array_bankrån = arrayOf("Adjektiv som slutar på: a", "Siffra", "Tidsenhet", "Siffra", "Dåligt artistnamn", "Superhjälte", "Verb som slutar på: ar", "Känt citat", "Namn på hundvalp", "Verb som slutar på: a", "Kroppsdel", "Skurk", "Vapen i plural", "Siffra", "Tidsenhet i plural", "Siffra", "Substantiv i plural", "Substantiv i plural som slutar på: a", "Fordon i bestämd form", "Geografisk plats", "Högtid", "")

        progressBar_bankrån.progress = 0

        random_generator.random_tips(tips_text_banrån)

        buttonEffect(spela_button_bankrån)

        back_button_bankrån.setOnClickListener {
            array_bankrån = arrayOf("Adjektiv som slutar på: a", "Siffra", "Tidsenhet", "Siffra", "Dåligt artistnamn", "Superhjälte", "Verb som slutar på: ar", "Känt citat", "Namn på hundvalp", "Verb som slutar på: a", "Kroppsdel", "Skurk", "Vapen i plural", "Siffra", "Tidsenhet i plural", "Siffra", "Substantiv i plural", "Substantiv i plural som slutar på: a", "Fordon i bestämd form", "Geografisk plats", "Högtid", "")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@bankran.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_bankrån.setText("Textlängd: Lång")
        var counter = 0

        spela_button_bankrån.setOnClickListener {
            progressBar_bankrån.visibility = View.VISIBLE
            input_text_bankrån.visibility = View.VISIBLE
            confirm_button_bankrån.visibility = View.VISIBLE
            spela_button_bankrån.visibility = View.INVISIBLE
            desc_text_bankrån.setText(array_bankrån[counter])
            antal_ord_bankrån.visibility = View.INVISIBLE




            counter++
        }

        confirm_button_bankrån.setOnClickListener {
            if (counter < array_bankrån.size) {
                progressBar_bankrån.progress = (progressBar_bankrån.progress + 4)%100
                desc_text_bankrån.setText(array_bankrån[counter])
                array_bankrån[counter - 1] = input_text_bankrån.getText().toString()
                counter++
                textStory_bankrån = "Okej, det här är den " + array_bankrån[0] + " planen jag kom på, jag har arbetat med den i " + array_bankrån[1] + " " + array_bankrån[2] + " så den kommer definitivt med " + array_bankrån[3] + " procent sannolikhet att fungera. Det här är planen, " + array_bankrån[4] + " du klär ut dig till " + array_bankrån[5] + ", går in till banken, ställer dig på en stol och " + array_bankrån[6] + " samtidigt som du skriker ut '" + array_bankrån[7] + "'. Allt detta för att skapa en distraktion för " + array_bankrån[8] + " vars uppgift är sno vaktens vapen, om du blir påkommen är planen att snabbt börja " + array_bankrån[9] + " med vakten och under tiden köra in en spruta med sömnmedel i vaktens " + array_bankrån[10] + ". Då vakten är neutraliserad så kommer jag och " + array_bankrån[11] + " in, tar upp våra " + array_bankrån[12] + " och hotar bankpersonalen att ge oss koden till valvet. Vi har då exakt " + array_bankrån[13] + " " + array_bankrån[14] + " att ta oss in i och rensa valvet innan polisen kommer. Om någon inifrån banken försöker göra motstånd så har jag " + array_bankrån[15] + " " + array_bankrån[16] + " med mig som vi kan använda oss av för att stoppa potentiellt motstånd. Vi vill inte riskera att använda våra " + array_bankrån[12] + " om det inte är absolut nödsituation. Kom ihåg det är endast dom extremt värdefulla " + array_bankrån[17] + "na som vi vill åt, inget annat. Vi springer sen ut genom bakvägen till " + array_bankrån[18] + " och kör iväg, sedan delar vi upp oss och möts vid " + array_bankrån[19] + " så vi kan dela upp bytet. Det är planen och vi genomför den på " + array_bankrån[20] + "."
                input_text_bankrån.setText("")

            } else {
                counter++
            }

            if (counter == array_bankrån.size) {
                text_story_bankrån.setText(textStory_bankrån)
                progressBar_bankrån.visibility = View.INVISIBLE
                desc_text_bankrån.visibility = View.INVISIBLE
                confirm_button_bankrån.visibility = View.INVISIBLE
                input_text_bankrån.visibility = View.INVISIBLE
                tips_text_banrån.visibility = View.INVISIBLE
                tips_title_bankrån.visibility = View.INVISIBLE
                array_bankrån = arrayOf("Adjektiv som slutar på: a", "Siffra", "Tidsenhet", "Siffra", "Dåligt artistnamn", "Superhjälte", "Verb som slutar på: ar", "Känt citat", "Namn på hundvalp", "Verb som slutar på: a", "Kroppsdel", "Skurk", "Vapen i plural", "Siffra", "Tidsenhet i plural", "Siffra", "Substantiv i plural", "Substantiv i plural som slutar på: a", "Fordon i bestämd form", "Geografisk plats", "Högtid", "")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)

            }
        }

    }

    fun buttonEffect(button: View) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(resources.getColor(R.color.abc_hint_foreground_material_light), PorterDuff.Mode.SRC_ATOP)
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
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
            .setCancelable(false)
            .setPositiveButton("Ja",
                DialogInterface.OnClickListener { dialog, id -> this@bankran.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
