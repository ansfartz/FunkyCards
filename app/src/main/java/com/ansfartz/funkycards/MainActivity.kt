package com.ansfartz.funkycards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ansfartz.funkycards.ui.CardsListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cardsListBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardsListBtn = findViewById(R.id.cardsListButton)
        cardsListBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, CardsListActivity::class.java)
            startActivity(intent)
        }

    }
}