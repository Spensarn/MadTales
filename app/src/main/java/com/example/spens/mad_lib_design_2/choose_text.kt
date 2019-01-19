package com.example.spens.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_text.*

class choose_text : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_text)

        back_choose_text.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        presskonferens_button.setOnClickListener {
            val intent = Intent(this, presskonferens::class.java)
            startActivity(intent)
        }

        jobbintervju_button.setOnClickListener {
            val intent = Intent(this, jobbintervju::class.java)
            startActivity(intent)
        }
        bankrån_button.setOnClickListener {
            val intent = Intent(this, bankran::class.java)
            startActivity(intent)
        }

    }
}
