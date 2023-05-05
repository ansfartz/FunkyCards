package com.ansfartz.funkycards.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ansfartz.funkycards.R
import com.ansfartz.funkycards.model.Card
import com.ansfartz.funkycards.model.CardAdapter

class CardsListActivity : AppCompatActivity() {

    lateinit var cardAdapter: CardAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_list)

        recyclerView = findViewById(R.id.cardsRecyclerView)

        val cardsList = mutableListOf(
            Card("A giant robot that shoots lasers.", Card.Type.RESPONSE),
            Card("aaa", Card.Type.RESPONSE),
            Card("bbb", Card.Type.RESPONSE),
            Card("ccc", Card.Type.RESPONSE),
            Card("ddd", Card.Type.RESPONSE),
        )

        cardAdapter = CardAdapter(cardsList, object: CardAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                Log.d(TAG, "onItemClick: position $position")
            }

            override fun onItemLongClick(position: Int) {
                Log.d(TAG, "onItemLongClick: position $position")
            }
        })

        recyclerView.adapter = cardAdapter
        recyclerView.layoutManager = GridLayoutManager(this@CardsListActivity, 2, RecyclerView.VERTICAL, false)
    }

    companion object {
        private const val TAG = "CardsListActivity"
    }

}