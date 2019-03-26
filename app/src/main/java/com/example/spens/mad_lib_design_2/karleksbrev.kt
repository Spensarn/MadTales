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
import kotlinx.android.synthetic.main.activity_karleksbrev.*
import kotlinx.android.synthetic.main.activity_nyheter.*


class karleksbrev : AppCompatActivity() {

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karleksbrev)
        array_karleksbrev = arrayOf("Namn på någon i rummet","Adjektiv som slutar på: a","Djur","Verb som slutar på: ar","Arbete man hade förr i tiden","Siffra","Karaktär i en film","Svensk komiker","Möbel i bestämd form","Verb","Adjektiv","Adjektiv","Kropssdel i singular","Ovanlig akitvitet/sport","Djur i bestämd form","Person i rummet","")

        random_generator.random_tips(tips_text_kärleksbrev)

        progressBar_kärleksbrev.progress = 0

        back_button_kärleksbrev.setOnClickListener {
            array_karleksbrev = arrayOf("Namn på någon i rummet","Adjektiv som slutar på: a","Djur","Verb som slutar på: ar","Arbete man hade förr i tiden","Siffra","Karaktär i en film","Svensk komiker","Möbel i bestämd form","Verb","Adjektiv som slutar på: t","Adjektiv som slutar på: a","Kropssdel i singular","Ovanlig akitvitet/sport","Djur i bestämd form","Person i rummet","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@karleksbrev.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_kärleksbrev.setText("Textläng: Mellan" )
        var counter = 0

        spela_button_kärleksbrev.setOnClickListener {
            progressBar_kärleksbrev.visibility = View.VISIBLE
            input_text_kärleksbrev.visibility = View.VISIBLE
            confirm_button_kärleksbrev.visibility = View.VISIBLE
            spela_button_kärleksbrev.visibility = View.INVISIBLE
            desc_text_kärleksbrev.setText(array_karleksbrev[counter])
            antal_ord_kärleksbrev.visibility = View.INVISIBLE
            procent_dislike_kärleksbrev.visibility = View.INVISIBLE
            procent_like_kärleksbrev.visibility = View.INVISIBLE
            //like_image_företagspitch.visibility = View.INVISIBLE
            //dislike_image_företagspitch.visibility = View.INVISIBLE


            counter++
        }

        confirm_button_kärleksbrev.setOnClickListener {
            if (counter < array_karleksbrev.size) {
                progressBar_kärleksbrev.progress = (progressBar_kärleksbrev.progress+6)
                desc_text_kärleksbrev.setText(array_karleksbrev[counter])
                array_karleksbrev[counter - 1] = input_text_kärleksbrev.getText().toString()
                counter++
                textStory_karleksbrev = "Hej " + array_karleksbrev[0]+ ", det var länge sedan jag hörde av mig till dig och jag saknar dig så himla mycket min " + array_karleksbrev[1]+ " lilla " + array_karleksbrev[2]+ ", vet att du inte gillar det smeknamnet men det passar ju dig så bra! Just nu sitter jag och " + array_karleksbrev[3] + " samtidigt som jag skriver detta brev till dig, imorgon börjar jag min första dag som " + array_karleksbrev[4] + ", jag är lite nervös men det ska bli kul. Jag har fått en liten lägenhet på " + array_karleksbrev[5] + " kvadrat mitt i stan nära jobbet, mina två rumskompisar " + array_karleksbrev[6] + " och " + array_karleksbrev[7] + " är väldigt snälla mot mig och vi har kul tillsammans. Vi tre brukar lägga oss i " + array_karleksbrev[8] + " under en mysig filt med tända ljus och " + array_karleksbrev[9] + " och titta på TV varje söndag, det är super " + array_karleksbrev[10] + ". Saknar verkligen dig så mycket, ligger ofta och tänker på ditt " + array_karleksbrev[11] + " leende och din stora fina " + array_karleksbrev[12] + ", längtar till du kommer och hälsar på. Hur har du det? Hörde att du börjat med " + array_karleksbrev[13] + ", låter superkul, du får visa hur man gör nästa gång vi ses. Hörde också att ni skaffat den där " + array_karleksbrev[14] + " som du så länge tjatat om att skaffa, vad roligt! Skicka många bilder på den, vill se hur den ser ut! Nu måste jag gå. Vi hörs senare!\n" + "/" + array_karleksbrev[15] +" \n"
                input_text_kärleksbrev.setText("")


            } else {
                counter++
            }

            if (counter == array_karleksbrev.size) {
                text_story_kärleksbrev.setText(textStory_karleksbrev)
                progressBar_kärleksbrev.visibility = View.INVISIBLE
                desc_text_kärleksbrev.visibility = View.INVISIBLE
                confirm_button_kärleksbrev.visibility = View.INVISIBLE
                input_text_kärleksbrev.visibility = View.INVISIBLE
                tips_text_kärleksbrev.visibility = View.INVISIBLE
                tips_title_kärleksbrev.visibility = View.INVISIBLE
                array_karleksbrev = arrayOf("Namn på någon i rummet","Adjektiv som slutar på: a","Djur","Verb som slutar på: ar","Arbete man hade förr i tiden","Siffra","Karaktär i en film","Svensk komiker","Möbel i bestämd form","Verb","Adjektiv","Adjektiv","Kropssdel i singular","Ovanlig akitvitet/sport","Djur i bestämd form","Person i rummet","")

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
                DialogInterface.OnClickListener { dialog, id -> this@karleksbrev.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
