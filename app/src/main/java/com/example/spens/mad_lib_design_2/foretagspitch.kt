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
import android.support.v4.widget.TextViewCompat
import kotlinx.android.synthetic.main.activity_choose_text.*


class foretagspitch : AppCompatActivity() {

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foretagspitch)
        array_företagspitch = arrayOf("Namn", "Siffra","Grönsak på engelska", "Substantiv i singular","Verb","Butikskedja i plural","Land","Land","Siffra","Årtal","Hemsida","Namn på by","Låg siffra","Substantiv i plural","Hög siffra","Tidsenhet","Namn innehållande 3 boktsåver","Kändis","Kroppsdel i best form","Siffra","")

        random_generator.random_tips(tips_text_företagspitch)

        progressBar_företagspitch.progress = 0

        back_button_företagspitch.setOnClickListener {
            array_företagspitch = arrayOf("Namn", "Siffra","Grönsak på engelska", "Substantiv i singular","Verb","Butikskedja i plural","Land","Land","Siffra","Årtal","Hemsida","Namn på by","Låg siffra","Substantiv i plural","Hög siffra","Tidsenhet","Namn innehållande 3 boktsåver","Kändis","Kroppsdel i best form","Siffra","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@foretagspitch.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_företagspitch.setText("Textläng: Lång" )
        var counter = 0

        spela_button_företagspitch.setOnClickListener {
            //företagspitch_button.visibility = View.INVISIBLE
            progressBar_företagspitch.visibility = View.VISIBLE
            input_text_företagspitch.visibility = View.VISIBLE
            confirm_button_företagspitch.visibility = View.VISIBLE
            spela_button_företagspitch.visibility = View.INVISIBLE
            desc_text_företagspitch.setText(array_företagspitch[counter])
            antal_ord_företagspitch.visibility = View.INVISIBLE
            procent_dislike_företagspitch.visibility = View.INVISIBLE
            procent_like_företagspitch.visibility = View.INVISIBLE
            //like_image_företagspitch.visibility = View.INVISIBLE
            //dislike_image_företagspitch.visibility = View.INVISIBLE

            counter++
        }

        confirm_button_företagspitch.setOnClickListener {
            if (counter < array_företagspitch.size) {
                progressBar_företagspitch.progress = (progressBar_företagspitch.progress+5)%100
                desc_text_företagspitch.setText(array_företagspitch[counter])
                array_företagspitch[counter - 1] = input_text_företagspitch.getText().toString()
                counter++
                textstory_företagspitch = "Hejsan jag heter " + array_företagspitch[0]+ " och står framför er här idag för att få en investering på " + array_företagspitch[1]+ " kronor. Min produk heter " + array_företagspitch[2]+ " och är en " + array_företagspitch[3]+ " som kan användas för att underlätta när man ska " + array_företagspitch[4]+ ". Just nu säljer vi vår produkt i alla " + array_företagspitch[5]+ " i " + array_företagspitch[6]+ " och ska utvidga oss till " + array_företagspitch[7]+ " nästa kvartal. Vi har totalt sett sålt " + array_företagspitch[8]+ " enheter sedan " + array_företagspitch[9]+ " då jag startade företaget. Några frågor? (Investerare) Ja jag har två frågor. Hur tänkte ni annonsera produkten? Och vad är er årliga omsättning och vinst? (" + array_företagspitch[0]+ ") Ja vi ska annonsera på hemsidor som exempelvis " + array_företagspitch[10]+ " och vi har även hyrt en anslagstavla i " + array_företagspitch[11]+ " där vi tror många kunder kommer lockas att köpa produkten. Våran omsättning förra året var på ca " + array_företagspitch[12]+ " kronor inklusive 44 st " + array_företagspitch[13]+ " men av lagliga skäl tog vi inte med det i våran årsredovisning. Vi gick minus " + array_företagspitch[14]+ " i vinst, alltså ingen vinst alls men vi är positiva ändå, jag tror att om ca 10 " + array_företagspitch[15]+ " kan vi ligga på plus minus noll och inom nolltid gå med vinst. (Investerare) Hur många anställda har företaget? (" + array_företagspitch[0]+ ") Just nu är det bara jag, min kompis " + array_företagspitch[16]+ " och faktiskt " + array_företagspitch[17]+ " , båda jobbar med produktionen, vet inte riktigt varför " + array_företagspitch[17]+ " jobbar hos oss men det är kul antar jag. Vi hade 200 anställda förra året men alla skadade " + array_företagspitch[18]+ " och fick sluta. På grund av detta är vi skyldiga ca " + array_företagspitch[19]+ " kronor till dessa människor, det är därför jag står här idag. Era pengar kommer nämligen gå åt till att försöka betala av, i alla fall en andel av skulden. (Investerare) Då tror jag vi är färdiga här, vi kommer återkomma inom 1 vecka om beslut, till dess ha en bra dag. Hejdå!"
                input_text_företagspitch.setText("")


            } else {
                counter++
            }

            if (counter == array_företagspitch.size) {


                text_story_företagspitch.setText(textstory_företagspitch)
                progressBar_företagspitch.visibility = View.INVISIBLE
                desc_text_företagspitch.visibility = View.INVISIBLE
                confirm_button_företagspitch.visibility = View.INVISIBLE
                input_text_företagspitch.visibility = View.INVISIBLE
                tips_text_företagspitch.visibility = View.INVISIBLE
                tips_title_företagspitch.visibility = View.INVISIBLE
                continue_button_företagspitch.visibility = View.VISIBLE
                array_företagspitch = arrayOf("Namn", "Siffra","Grönsak på engelska", "Substantiv i singular","Verb","Butikskedja i plural","Land","Land","Siffra","Årtal","Hemsida","Namn på by","Låg siffra","Substantiv i plural","Hög siffra","Tidsenhet","Namn innehållande 3 boktsåver","Kändis","Kroppsdel i best form","Siffra","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)


                continue_button_företagspitch.setOnClickListener {
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
                DialogInterface.OnClickListener { dialog, id -> this@foretagspitch.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
