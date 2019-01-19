package com.example.spens.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_bankran.*

class bankran : AppCompatActivity() {

    var calc_procent_counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bankran)


       /* fun rating_click() {
            like_button.setOnClickListener{
                rating_variables.total_clicks++
                rating_variables.total_likes++
                like_button.isClickable = false
                Log.d("total_likes", rating_variables.total_likes.toString())
                Log.d("total_ratings", rating_variables.total_clicks.toString())
            }
            dislike_button.setOnClickListener {
                rating_variables.total_clicks++
                rating_variables.total_dislikes++
                dislike_button.isClickable = false
                Log.d("dislike", rating_variables.total_dislikes.toString())
                Log.d("total_ratings", rating_variables.total_clicks.toString())

            }
        }

     fun calc_procent(){
        rating_variables.procent_likes = (rating_variables.total_likes / rating_variables.total_clicks)*100
        rating_variables.procent_dislikes = (rating_variables.total_dislikes / rating_variables.total_clicks)*100
        Log.d("procent_likes", rating_variables.procent_likes.toString())
        Log.d("procent_dislikes", rating_variables.procent_dislikes.toString())


    }*/

        back_button_bankrån.setOnClickListener {
            array_bankrån = arrayOf("Adjektiv som slutar på: a", "Siffra", "Tidsenhet","Siffra","Dåligt artistnamn","Superhjälte","Verb som slutar på: ar","Känt citat","Namn på hundvalp","Verb som slutar på: a","Kroppsdel","Skurk","Vapen i plural","Siffra","Tidsenhet","Siffra","Substantiv i plural","Substantiv i plural","Fordon som slutar på: n","Geografisk plats","Högtid","")
            val intent = Intent(this, choose_text::class.java)
            startActivity(intent)

        }
        calc_procent_counter++
        if(calc_procent_counter == 1) {
            //calc_procent()
        }


        antal_ord_bankrån.setText("Ord:" + " " + array_bankrån.size)
        //procent_like.setText(rating_variables.procent_likes.toString()+ "%")
        //procent_dislike.setText(rating_variables.procent_dislikes.toString()+"%")
        var counter = 0

        spela_button_bankrån.setOnClickListener {
            input_text_bankrån.visibility = View.VISIBLE
            confirm_button_bankrån.visibility = View.VISIBLE
            spela_button_bankrån.visibility = View.INVISIBLE
            desc_text_bankrån.setText(array_bankrån[counter])
            antal_ord_bankrån.visibility = View.INVISIBLE
            procent_dislike.visibility = View.INVISIBLE
            procent_like.visibility = View.INVISIBLE
            like_button.visibility = View.INVISIBLE
            dislike_button.visibility = View.INVISIBLE
            like_image.visibility = View.INVISIBLE
            dislike_image.visibility = View.INVISIBLE



            counter++
        }

        confirm_button_bankrån.setOnClickListener {
            if (counter < array_bankrån.size) {
                desc_text_bankrån.setText(array_bankrån[counter])
                array_bankrån[counter - 1] = input_text_bankrån.getText().toString()
                counter++
                textStory_bankrån = "Okej, det här är den " + array_bankrån[0] + "planen jag kom på, jag har arbetat med den i " + array_bankrån[1] + " " + array_bankrån[2] + "  så den kommer definitivt med " + array_bankrån[3] + " procent sannolikhet att fungera. Det här är planen: " + array_bankrån[4] + " du klär ut dig till " + array_bankrån[5] + ", går in till banken, ställer dig på en stol och " + array_bankrån[6] + " samtidigt som du skriker ut " + array_bankrån[7] + ". Allt detta för att skapa en distraktion för " + array_bankrån[8] + " vars uppgift är sno vaktens vapen, om du blir påkommen är planen att snabbt börja " + array_bankrån[9] + " med vakten och under tiden köra in en spruta med sömnmedel i vaktens " + array_bankrån[10] + ". Då vakten är neutraliserad så kommer jag och " + array_bankrån[11] + " in, tar upp våra " + array_bankrån[12] + " och hotar bankpersonalen att ge oss koden till valvet. Vi har då exakt " + array_bankrån[13] + " " + array_bankrån[14] + " att ta oss in i och rensa valvet innan polisen kommer. Om någon inifrån banken försöker göra motstånd så har jag " + array_bankrån[15] + " " + array_bankrån[16] + " med mig som vi kan använda oss av för att stoppa potentiellt motstånd. Vi vill inte riskera att använda våra " + array_bankrån[12] + " om det inte är absolut nödsituation. Kom ihåg det är endast dom extremt värdefulla " + array_bankrån[17] + " som vi vill åt, inget annat. Vi springer sen ut genom bakvägen till " + array_bankrån[18] + "  och kör iväg, sedan delar vi upp oss och möts vid " + array_bankrån[19] + " så vi kan dela upp bytet. Det är planen och vi genomför den på " + array_bankrån[20] + "."
                input_text_bankrån.setText("")


            } else {
                counter++
            }

            if (counter == array_bankrån.size) {
                text_story_bankrån.setText(textStory_bankrån)
                desc_text_bankrån.visibility = View.INVISIBLE
                confirm_button_bankrån.visibility = View.INVISIBLE
                input_text_bankrån.visibility = View.INVISIBLE
                dislike_button.visibility = View.VISIBLE
                like_button.visibility = View.VISIBLE
                array_bankrån = arrayOf("Adjektiv som slutar på: a", "Siffra", "Tidsenhet", "Siffra", "Dåligt artistnamn", "Superhjälte", "Verb som slutar på: ar", "Känt citat", "Namn på hundvalp", "Verb som slutar på: a", "Kroppsdel", "Skurk", "Vapen i plural", "Siffra", "Tidsenhet", "Siffra", "Substantiv i plural", "Substantiv i plural som slutar på:a", "Fordon som slutar på: n", "Geografisk plats", "Högtid", "")
                //rating_click()
                //calc_procent()
            }


        }

    }
}
