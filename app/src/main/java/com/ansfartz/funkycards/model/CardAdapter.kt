package com.ansfartz.funkycards.model

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ansfartz.funkycards.R
import com.ansfartz.funkycards.model.CardAdapter.CardViewHolder

class CardAdapter(
    private val cards: MutableList<Card>,
    var itemClickListener: ItemClickListener?,
) : RecyclerView.Adapter<CardViewHolder>(){


    interface ItemClickListener {
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.cardText.text = cards[position].text

        holder.itemView.setOnClickListener {
            if (itemClickListener != null) {
                itemClickListener!!.onItemClick(position)
            }
        }

        holder.itemView.setOnLongClickListener {
            if (itemClickListener != null) {
                itemClickListener!!.onItemLongClick(position)
                true
            } else {
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardText: TextView

        init {
            cardText = itemView.findViewById(R.id.cardText)
        }
    }


}