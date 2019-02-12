package com.example.spens.mad_lib_design_2

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_jobbintervju.*
import kotlinx.android.synthetic.main.activity_presskonferens.*

class jobbintervju : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobbintervju)

        buttonEffect(spela_button_jobbintervju)


        back_button_jobbintervju.setOnClickListener {
            array_jobbintervju = arrayOf(
                " Skådespelare",
                "Namn på en historisk figur",
                "Typ av arbete",
                "Något du säger när du är i knipa",
                "Typ av spel",
                "Yrke man hade förr i tiden",
                "Tidsspann",
                "Namn på företag",
                "Siffra",
                "Valuta",
                "Något du säger när du blir chockad",
                "Adjektiv",
                "Siffra",
                " Badrumsartikel i plural",
                "Djur i plural",
                "Typ av släkting",
                "Namn",
                "Siffra",
                "Substantiv i plural",
                "Siffra",
                "Kroppsdel: best form",
                " Tidsspan",
                "Låt",
                ""
            )
            val intent = Intent(this, choose_text::class.java)
            startActivity(intent)

        }

        var counter = 0

        spela_button_jobbintervju.setOnClickListener {
            input_text_jobbintervju.visibility = View.VISIBLE
            confirm_button_jobbintervju.visibility = View.VISIBLE
            spela_button_jobbintervju.visibility = View.INVISIBLE
            desc_text_jobbintervju.setText(array_jobbintervju[counter])
            textlängd_jobbintervju.visibility = View.INVISIBLE
            counter++
        }

        confirm_button_jobbintervju.setOnClickListener {
            if (counter < array_jobbintervju.size) {
                desc_text_jobbintervju.setText(array_jobbintervju[counter])
                array_jobbintervju[counter - 1] = input_text_jobbintervju.getText().toString()
                counter++
                textStory_jobbintervju = "Intervjuare: " + array_jobbintervju[0] + " Jobbsökande " +
                        array_jobbintervju[1] + " Så... du vill alltså börja jobba som: " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[2] +
                        " Vad har du för kvalifikationer för detta arbete? " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[3] + " Ehm, jag är väldigt bra på " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[4] + ", jag har även jobbat som " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[5] + " i " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[6] +
                        ". Oj, ja det är väldigt bra meriter. Men varför vill du ta detta arbete. Jag vill ta jobbet för att jag är skyldig " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[7] +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[8] +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[9] + ". " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[10] + " .Du är verkligen i en " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[11] +
                        " knipa. Hur satte du dig i den positionen? Jag köpte " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[12] +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[13] + " och jag köpte 10 000 " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[14] + " till min " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[15] + " " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[16] +
                        ". Jaha, ja om du får detta jobb är din lön på en bra bit över " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[17] + " " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[18] +
                        " i månaden. Det borde täcka alla dina skulder. Jag måste som chef också informera dig om att ungefär " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[19] + " procent av de anställda skadar " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[20] +
                        " varje år. Ser du detta som ett problem? Det är inget problem för mig, jag opererade bort den för " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[21] +
                        " sedan. Okej, då är jobbet ditt, om du bara kan svara på en fråga till. Sjung en bit från låten " +
                        com.example.spens.mad_lib_design_2.array_jobbintervju[22] +
                        ". “Sjung”... Okej grattis du får jobbet!"
                input_text_jobbintervju.setText("")


            } else {
                counter++
            }

            if (counter == array_jobbintervju.size) {
                text_story_jobbintervju.setText(textStory_jobbintervju)
                desc_text_jobbintervju.visibility = View.INVISIBLE
                confirm_button_jobbintervju.visibility = View.INVISIBLE
                input_text_jobbintervju.visibility = View.INVISIBLE
                array_jobbintervju = arrayOf(
                    " Skådespelare",
                    "Namn på en historisk figur",
                    "Typ av arbete",
                    "Något du säger när du är i knipa",
                    "Typ av spel",
                    "Yrke man hade förr i tiden",
                    "Tidsspann",
                    "Namn på företag",
                    "Siffra",
                    "Valuta",
                    "Något du säger när du blir chockad",
                    "Adjektiv",
                    "Siffra",
                    " Badrumsartikel i plural",
                    "Djur i plural",
                    "Typ av släkting",
                    "Namn",
                    "Siffra",
                    "Substantiv i plural",
                    "Siffra",
                    "Kroppsdel: best form",
                    " Tidsspan",
                    "Låt",
                    ""
                )
                continue_button_jobbinervju.visibility = View.VISIBLE
                tips_text_jobbintervju.visibility = View.INVISIBLE
                tips_title_jobbintervju.visibility = View.INVISIBLE


                val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

                continue_button_jobbinervju.setOnClickListener {
                    val intent = Intent(this, continue_screen_bankran::class.java)
                    startActivity(intent)
                }
            }
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
