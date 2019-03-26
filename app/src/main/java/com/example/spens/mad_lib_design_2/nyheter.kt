package com.example.spens.mad_lib_design_2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_bankran.*
import android.app.Activity
import android.app.AlertDialog
import kotlinx.android.synthetic.main.activity_foretagspitch.*
import android.content.DialogInterface
import kotlinx.android.synthetic.main.activity_jakt.*
import kotlinx.android.synthetic.main.activity_nyheter.*


class nyheter : AppCompatActivity() {

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nyheter)
        array_nyheter = arrayOf("Namn på husdjur","Land","Siffra","Substantiv i plural","Superhjälte","Stad i Sverige","Person i rummet, förnamn och efternamn","Verb som slutar på: t","Substantiv i plural","Kroppsdel","Siffra","Mätenhet","Känd persom","Känd idrottsman","Olaglig aktivitet som slutar på: t","")

        random_generator.random_tips(tips_text_nyheter)

        progressBar_nyheter.progress = 0

        back_button_nyheter.setOnClickListener {
            array_nyheter = arrayOf("Namn på husdjur","Land","Siffra","Substantiv i plural","Superhjälte","Stad i Sverige","Person i rummet, förnamn och efternamn","Verb som slutar på: t","Substantiv i plural","Kroppsdel","Siffra","Mätenhet","Känd persom","Känd idrottsman","Olaglig aktivitet som slutar på: t","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@nyheter.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_nyheter.setText("Textläng: Mellan" )
        var counter = 0

        spela_button_nyheter.setOnClickListener {
            progressBar_nyheter.visibility = View.VISIBLE
            input_text_nyheter.visibility = View.VISIBLE
            confirm_button_nyheter.visibility = View.VISIBLE
            spela_button_nyheter.visibility = View.INVISIBLE
            desc_text_nyheter.setText(array_nyheter[counter])
            antal_ord_nyheter.visibility = View.INVISIBLE
            procent_dislike_nyheter.visibility = View.INVISIBLE
            procent_like_nyheter.visibility = View.INVISIBLE
            //like_image_företagspitch.visibility = View.INVISIBLE
            //dislike_image_företagspitch.visibility = View.INVISIBLE


            counter++
        }

        confirm_button_nyheter.setOnClickListener {
            if (counter < array_nyheter.size) {
                progressBar_nyheter.progress = (progressBar_nyheter.progress+6)
                desc_text_nyheter.setText(array_nyheter[counter])
                array_nyheter[counter - 1] = input_text_nyheter.getText().toString()
                counter++
                textStory_nyheter = "Hej och välkomna till kvällens nyheter, jag heter "+ array_nyheter[0] + ". Vi börjar med att vända oss mot " + array_nyheter[1] + " där cirka " + array_nyheter[2] + " mycket värdefulla " + array_nyheter[3] + " har försvunnit spårlöst. Polisen har anlitat " + array_nyheter[4] + " för att hitta de spårlöst försvunna " + array_nyheter[3] + "na, det finns inte tillräckligt med bevis för att säkerhetsställa om det rör sig om brott eller inte. Nu vidare till Sverige där polisen i " + array_nyheter[5] + " efterlyser " + array_nyheter[6] + " för att ha " + array_nyheter[7] + " och attackerat en man i 50 årsåldern ute på stan under lördagsnatten. Sökandet efter gärningsmannen har pågått sen i onsdags och ska enligt vittnet kastat " + array_nyheter[8] + " mot den utsatte mannen. Just nu finns inga spår var förövaren är men polisen hoppas att dom ska hitta den skyldige snart. I London har även nya världsrekordet i världens största " + array_nyheter[9] + " uppmätts, " + array_nyheter[9] + "en ska tydligen har slagit gamla rekordet med " + array_nyheter[10] + " " + array_nyheter[11] + ", personen som slagit detta rekord heter " + array_nyheter[12] + " och vill inte ge några kommentarer. Nu över till sportvärlden där " + array_nyheter[13] + " blivit häktad för att ha " + array_nyheter[14] + " och på grund av detta blivit gripen vid 8-tiden i fredags. Vi har ingen mer information om detta för tillfället. Det var allt för ikväll, vi ses imorgon. Hejdå!"
                input_text_nyheter.setText("")


            } else {
                counter++
            }

            if (counter == array_nyheter.size) {
                text_story_nyheter.setText(textStory_nyheter)
                progressBar_nyheter.visibility = View.INVISIBLE
                desc_text_nyheter.visibility = View.INVISIBLE
                confirm_button_nyheter.visibility = View.INVISIBLE
                input_text_nyheter.visibility = View.INVISIBLE
                tips_text_nyheter.visibility = View.INVISIBLE
                tips_title_nyheter.visibility = View.INVISIBLE
                array_nyheter = arrayOf("Namn på husdjur","Land","Siffra","Substantiv i plural","Superhjälte","Stad i Sverige","Person i rummet, förnamn och efternamn","Verb som slutar på: t","Substantiv i plural","Kroppsdel","Siffra","Mätenhet","Känd persom","Känd idrottsman","Olaglig aktivitet som slutar på: t","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)


            }

        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
            .setCancelable(false)
            .setPositiveButton("Ja",
                DialogInterface.OnClickListener { dialog, id -> this@nyheter.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
