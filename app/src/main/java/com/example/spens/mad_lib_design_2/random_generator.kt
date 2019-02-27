package com.example.spens.mad_lib_design_2

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_reklam.*

class random_generator{


    fun random_tips(textView: TextView){

        var random = (0..3).shuffled().last()
        if(random == 0){
            textView.setText("Använd ovanliga och kreativa ord för att få en roligare och mer underhållande text!")
        }
        if(random == 1){
            textView.setText("Det finns inga regler i detta spel. Tolka alla allt på ditt eget vis!")
        }
        if(random == 2){
            textView.setText("Var kreativ! Hitta på olika sätt att spela och gör egna regler!")
        }
        if(random == 3)
            textView.setText("Spelar ni i ett sällskap? Involvera alla i sällskapet!")
    }

    fun random_dialekt(){}

}