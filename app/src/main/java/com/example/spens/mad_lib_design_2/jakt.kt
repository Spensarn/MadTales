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


class jakt : AppCompatActivity() {

    val random_generator = com.example.spens.mad_lib_design_2.random_generator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jakt)
        array_jakt = arrayOf("Påhittat långt namn","Adjektiv som slutar på: a","Litet djur i bestämd form","Känd byggnad","siffra","Föremål som kan användas som vapen","Siffra","Barnleksak i plural","Fånigt smaknamn","Tidsenhet","Kroppsdel i bestämd form","Siffra","Tidsenhet","Bakverk","Svordom ett barn skulle säga","Verb som slutar på: a","Något du säger när du blir förvånad","")

        random_generator.random_tips(tips_text_jakt)

        progressBar_jakt.progress = 0

        back_button_jakt.setOnClickListener {
            array_jakt = arrayOf("Påhittat långt namn","Adjektiv som slutar på: a","Litet djur i bestämd form","Känd byggnad","siffra","Föremål som kan användas som vapen","Siffra","Barnleksak i plural","Fånigt smaknamn","Tidsenhet","Kroppsdel i bestämd form","Siffra","Tidsenhet","Bakverk","Svordom ett barn skulle säga","Verb som slutar på: a","Något du säger när du blir förvånad","")

            AlertDialog.Builder(this)
                .setMessage("Vill du avsluta? Ändringar kommer inte att sparas!")
                .setCancelable(false)
                .setPositiveButton("Ja",
                    DialogInterface.OnClickListener { dialog, id -> this@jakt.finish() })
                .setNegativeButton("Nej", null)
                .show()

        }

        antal_ord_jakt.setText("Textläng: Mellan" )
        var counter = 0

        spela_button_jakt.setOnClickListener {
            progressBar_jakt.visibility = View.VISIBLE
            input_text_jakt.visibility = View.VISIBLE
            confirm_button_jakt.visibility = View.VISIBLE
            spela_button_jakt.visibility = View.INVISIBLE
            desc_text_jakt.setText(array_jakt[counter])
            antal_ord_jakt.visibility = View.INVISIBLE
            procent_dislike_jakt.visibility = View.INVISIBLE
            procent_like_jakt.visibility = View.INVISIBLE
            //like_image_företagspitch.visibility = View.INVISIBLE
            //dislike_image_företagspitch.visibility = View.INVISIBLE


            counter++
        }

        confirm_button_jakt.setOnClickListener {
            if (counter < array_jakt.size) {
                progressBar_jakt.progress = (progressBar_jakt.progress+5)%100
                desc_text_jakt.setText(array_jakt[counter])
                array_jakt[counter - 1] = input_text_jakt.getText().toString()
                counter++
                textStory_jakt = "Hej och välkomna till jakt med " + array_jakt[0] +" idag ska vi jaga något speciellt, nämligen den ökända " + array_jakt[1] +" "+ array_jakt[2] +". Den har sitt näste precis här vid " + array_jakt[3]+ ". Det är ett mycket farligt och sällsynt djur, det finns bara "+ array_jakt[4] + " kvar idag. Bara ett vapen är till någon hjälp mot denna best och det är en "+ array_jakt[5] + ", om en nödsituation uppstår har vi "+ array_jakt[6] +" "+ array_jakt[7] + " lite utanför jaktområdet som är redo att användas mot "+ array_jakt[2] + " då det är så pass farligt. Många har försökt jaga det här monstret till varelse men misslyckats, min kompis "+ array_jakt[8] + " jagade i flera "+ array_jakt[9] + ", det var en tuff jakt och tillslut vann djuret, det slet av honom "+ array_jakt[10] + " och försvann sedan, "+ array_jakt[10] + " eller djuret har setts till sen dess. Men det kommer inte hända mig, jag kommer mycket förberedd till den här utmaningen, har tränat i minst "+ array_jakt[11] + " "+ array_jakt[12] + ". Ska försöka lura in djuret i en fälla, den lever endast på "+ array_jakt[13] + " så jag kan använda det till min fördel genom att lägga ut bete och sedan lägga mig i bakhåll. "+ array_jakt[14] + "! här kommer ju den, rakt mot oss! Börja "+ array_jakt[15] + " då skrämmer du den så hämtar jag "+ array_jakt[5] + "n. "+ array_jakt[16] + " jag tror jag glömde den hemma, ajdå..."
                input_text_jakt.setText("")


            } else {
                counter++
            }

            if (counter == array_jakt.size) {
                text_story_jakt.setText(textStory_jakt)
                progressBar_jakt.visibility = View.INVISIBLE
                desc_text_jakt.visibility = View.INVISIBLE
                confirm_button_jakt.visibility = View.INVISIBLE
                input_text_jakt.visibility = View.INVISIBLE
                tips_text_jakt.visibility = View.INVISIBLE
                tips_title_jakt.visibility = View.INVISIBLE
                continue_button_jakt.visibility = View.VISIBLE
                array_jakt = arrayOf("Påhittat långt namn","Adjektiv som slutar på: a","Litet djur i bestämd form","Känd byggnad","siffra","Föremål som kan användas som vapen","Siffra","Barnleksak i plural","Fånigt smaknamn","Tidsenhet","Kroppsdel i bestämd form","Siffra","Tidsenhet","Bakverk","Svordom ett barn skulle säga","Verb som slutar på: a","Något du säger när du blir förvånad","")

                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0)


                continue_button_jakt.setOnClickListener {
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
                DialogInterface.OnClickListener { dialog, id -> this@jakt.finish() })
            .setNegativeButton("Nej", null)
            .show()
    }
}
