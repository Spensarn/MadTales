package com.example.spens.mad_lib_design_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_continue_screen_bankran.*

class continue_screen_bankran : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue_screen_bankran)

        back_toText_bankrån.setOnClickListener {
            val intent = Intent(this, choose_text::class.java)
            startActivity(intent)
        }
    }
}
