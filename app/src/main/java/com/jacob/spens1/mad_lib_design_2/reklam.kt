package com.jacob.spens1.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import kotlinx.android.synthetic.main.activity_reklam.*


class reklam : AppCompatActivity() {

    val random_generator = random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reklam)

        progressBar_reklam.progress = 0

        random_generator.random_tips(tips_text_reklam)

        array_reklam = arrayOf("Kroppsdel i bestämd form","Något som äcklar dig","Föremål i ett hushåll i bestämd form","Något annat som äcklar dig","Namn som låter adligt","Adjektiv","Möbel i bestämd form","Verb","Substantiv i bestämd form","Tidsspann","Typ av släkting","Adjektiv","Siffra","Valuta","Adjektiv","Låg siffra","Verb","Substantiv i plural","")

        back_button_reklam.setOnClickListener {
            array_reklam = arrayOf("Kroppsdel i bestämd form","Något som äcklar dig","Föremål i ett hushåll i bestämd form","Något annat som äcklar dig","Namn som låter adligt","Adjektiv","Möbel i bestämd form","Verb","Substantiv i bestämd form","Tidsspann","Typ av släkting","Adjektiv","Siffra","Valuta","Adjektiv","Låg siffra","Verb","Substantiv i plural","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@reklam.finish() })
                .setNegativeButton("Nej", null)
                .show()

            //val intent = Intent(this, choose_text::class.java)
            //startActivity(intent)


        }

        antal_ord_reklam.setText("Textläng: Kort" )
        var counter = 0

        spela_button_reklam.setOnClickListener {
            progressBar_reklam.visibility = View.VISIBLE
            input_text_reklam.visibility = View.VISIBLE
            confirm_button_reklam.visibility = View.VISIBLE
            spela_button_reklam.visibility = View.INVISIBLE
            desc_text_reklam.setText(array_reklam[counter])
            antal_ord_reklam.visibility = View.INVISIBLE



            counter++
        }

        confirm_button_reklam.setOnClickListener {
            if (counter < array_reklam.size) {
                progressBar_reklam.progress = (progressBar_reklam.progress + 5)%100
                Log.d("Namn", array_reklam[0])
                desc_text_reklam.setText(array_reklam[counter])
                array_reklam[counter - 1] = input_text_reklam.getText().toString()
                counter++
                textStory_reklam = "Trött på att alltid behöva använda " + array_reklam[0] + " när du ska torka bort " + array_reklam[1] + "fläckar från " + array_reklam[2] + "? Har du svårt att finna ro i vardagen för den där pölen med " + array_reklam[3] + " bara dyker upp och du vet inte hur man ska få bort den? Jag heter " + array_reklam[4] + " och presenterar " + array_reklam[5] + " Städarna. Vi hjälper dig att städa rent hela hushållet. Vill du bara ligga i " + array_reklam[6] + " och " + array_reklam[7] + " hela helgen istället för att ta fram " + array_reklam[8] + " och städa? Vi är lösningen! Det tar endast oss " + array_reklam[9] + " att genomföra en städning och just nu rengör vi också din " + array_reklam[10] + " så han eller hon är " + array_reklam[11] + " och ren. Allt detta för endast " + array_reklam[12] + " " + array_reklam[13] + " i timmen. Jag och mina kollegor jobbar dygnet runt för att kunden ska bli så " + array_reklam[14] + " som möjligt efter vi genomfört vårt arbete. " + array_reklam[15] + " procent av våra kunder är nöjda och beställer gärna våran tjänst igen. Så tveka inte, hör av dig till oss nu! Obs! Vi tar inget ansvar om din " + array_reklam[10] + " plötsligt börjar " + array_reklam[16] + " okontrollerat eller om " + array_reklam[17] + " plötsligt börjar försvinna från ert hem."
                input_text_reklam.setText("")



            } else {
                counter++
            }

            if (counter == array_reklam.size) {
                text_story_reklam.setText(textStory_reklam)
                progressBar_reklam.visibility = View.INVISIBLE
                desc_text_reklam.visibility = View.INVISIBLE
                confirm_button_reklam.visibility = View.INVISIBLE
                input_text_reklam.visibility = View.INVISIBLE
                tips_text_reklam.visibility = View.INVISIBLE
                tips_title_reklam.visibility = View.INVISIBLE
                array_reklam = arrayOf("Kroppsdel i bestämd form","Något som äcklar dig","Föremål i ett hushåll i bestämd form","Något annat som äcklar dig","Namn som låter adligt","Adjektiv","Möbel i bestämd form","Verb","Substantiv i bestämd form","Tidsspann","Typ av släkting","Adjektiv","Siffra","Valuta","Adjektiv","Låg siffra","Verb","Substantiv i plural","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)


                continue_button_reklam.setOnClickListener {
                    val intent = Intent(this, continue_screen_bankran::class.java)
                    startActivity(intent)
                }
            }

        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
            .setCancelable(false)
            .setPositiveButton("Ja",
                DialogInterface.OnClickListener { dialog, id -> this@reklam.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}

