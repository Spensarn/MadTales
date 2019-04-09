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
import android.content.DialogInterface
import android.graphics.PorterDuff
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_matlagning.*
import kotlinx.android.synthetic.main.activity_reklam.*


class matlagning : AppCompatActivity() {


    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matlagning)
        array_matlagning = arrayOf("Typ av fisk","Något illaluktande","Substantiv i bestämd form","Vätska","Verb","Klädesplagg i plural","Hög siffra","Ingrediens vid matlagning","Verb","Adjektiv som slutar på: a","Något som smakar äckligt","Ord man säger om något smakar gott","En känsla","Adjektiv","Substantiv i bestämd form","Siffra","Mätenhet","Vätska","Tidsspann","Något som är dåligt för kroppen att äta","Stark alkohol","Färg","Sjukdom","Kroppsdel","")

        progressBar_matlagning.progress = 0

        random_generator.random_tips(tips_text_matlagning)

        buttonEffect(spela_button_matlagning)

        back_button_matlagning.setOnClickListener {
            array_matlagning = arrayOf("Typ av fisk","Något illaluktande","Substantiv i bestämd form","Vätska","Verb","Klädesplagg i plural","Hög siffra","Ingrediens vid matlagning","Verb","Adjektiv som slutar på: a","Något som smakar äckligt","Ord man säger om något smakar gott","En känsla","Adjektiv","Substantiv i bestämd form","Siffra","Mätenhet","Vätska","Tidsspann","Något som är dåligt för kroppen att äta","Stark alkohol","Färg","Sjukdom","Kroppsdel","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@matlagning.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_matlagning.setText("Textlängd: Lång")
        var counter = 0

        spela_button_matlagning.setOnClickListener {
            progressBar_matlagning.visibility = View.VISIBLE
            input_text_matlagning.visibility = View.VISIBLE
            confirm_button_matlagning.visibility = View.VISIBLE
            spela_button_matlagning.visibility = View.INVISIBLE
            desc_text_matlagning.setText(array_matlagning[counter])
            antal_ord_matlagning.visibility = View.INVISIBLE
            procent_dislike_matlagning.visibility = View.INVISIBLE
            procent_like_matlagning.visibility = View.INVISIBLE

            counter++
        }

        confirm_button_matlagning.setOnClickListener {
            if (counter < array_matlagning.size) {
                progressBar_matlagning.progress = (progressBar_matlagning.progress + 4)%100
                desc_text_matlagning.setText(array_matlagning[counter])
                array_matlagning[counter - 1] = input_text_matlagning.getText().toString()
                counter++
                textStory_matlagning = "Hejsan, idag ska vi lära oss laga inbakad " + array_matlagning[0] + " med smak av " + array_matlagning[1] + ". Det första steget är väldigt enkelt, ta fram " + array_matlagning[2] + " och " + array_matlagning[0] + "en, nu kan ni antingen välja att blanda ned " + array_matlagning[0] + "en med " + array_matlagning[3] + " eller använda " + array_matlagning[2] + " och sakta " + array_matlagning[4] + " på fisken. Nästa steg är lite svårare, nu ska ni ta på er era " + array_matlagning[5] + " för att ingen ska bränna sig, för vi ska värma upp ugnen till " + array_matlagning[6] + " grader. Medans ugnen blir varm ska ni blanda ned " + array_matlagning[7] + " med fisken, ett tips nu är att " + array_matlagning[8] + " riktigt rejält med fisken för att få fram den där " + array_matlagning[9] + " smaken av " + array_matlagning[10] + ". " + array_matlagning[11] + " nu börjar man bli lite " + array_matlagning[12] + ", " + array_matlagning[0] + "en luktar ju redan väldigt " + array_matlagning[13] + ". Bara några steg kvar, nu ska vi ta fram kockens viktigaste redskap, " + array_matlagning[14] + " och den ska vi använda för att blanda ihop fisken med " + array_matlagning[15] + " " + array_matlagning[16] + " " + array_matlagning[17] + ". Nu kan vi slänga in fisken i ugnen, den ska vara där i " + array_matlagning[18] + " så medans vi väntar kan man ta sig lite " + array_matlagning[19] + " som aptitretare eller för dom vuxna ett glas " + array_matlagning[20] + ". När " + array_matlagning[0] + " börjar se " + array_matlagning[21] + " ut är den redo att tas ut ur ugnen. Nu kan ni krydda med " + array_matlagning[1] + " och servera, om fisken varit i ugnen för kort tid finns det risk att man kan få " + array_matlagning[22] + " så var väldigt försiktiga innan ni börjar äta. Skär också gärna bort fiskens " + array_matlagning[23] + " då den inte smakar särskilt gott. Nu är allt redo att serveras, smaklig måltid!"
                input_text_matlagning.setText("")

            } else {
                counter++
            }

            if (counter == array_matlagning.size) {
                text_story_matlagning.setText(textStory_matlagning)
                progressBar_matlagning.visibility = View.INVISIBLE
                desc_text_matlagning.visibility = View.INVISIBLE
                confirm_button_matlagning.visibility = View.INVISIBLE
                input_text_matlagning.visibility = View.INVISIBLE
                tips_text_matlagning.visibility = View.INVISIBLE
                tips_title_matlagning.visibility = View.INVISIBLE
                array_matlagning = arrayOf("Typ av fisk","Något illaluktande","Substantiv i bestämd form","Vätska","Verb","Klädesplagg i plural","Hög siffra","Ingrediens vid matlagning","Verb","Adjektiv som slutar på: a","Något som smakar äckligt","Ord man säger om något smakar gott","En känsla","Adjektiv","Substantiv i bestämd form","Siffra","Mätenhet","Vätska","Tidsspann","Något som är dåligt för kroppen att äta","Stark alkohol","Färg","Sjukdom","Kroppsdel","")

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
                DialogInterface.OnClickListener { dialog, id -> this@matlagning.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
