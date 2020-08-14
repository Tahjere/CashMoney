package com.example.cashmoney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quotelayout.view.*

class QuoteAdapter(): RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {
    private val quoteList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = TextView(parent.context)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.text = quoteList[position]
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    fun add(text: String){
      quoteList.add(text)
      notifyItemInserted(quoteList.size - 1)
 }

    class ViewHolder(val view: TextView): RecyclerView.ViewHolder(view) {
    }
}
