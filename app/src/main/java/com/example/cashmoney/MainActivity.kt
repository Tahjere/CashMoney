package com.example.cashmoney

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var listOfRandomQuotes: List<String> = listOf("Jasmina: Business logic","Sean: Greater Works", "JT: Application(apply)", "Ed: Professionalism","Syed: Adaptability", "Kevin: Vulnerability", "Todd: Genuine " )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        requestQuotes()
        recyclerQuotes.adapter = QuoteAdapter()
//        recyclerQuotes.addItemDecoration(
//            DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
//        )
       recyclerQuotes.layoutManager = object: LinearLayoutManager(this){
            override fun canScrollVertically() = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun requestQuotes() {
        requestQuoteButton.setOnClickListener {
            val selector = listOfRandomQuotes.random()
           (recyclerQuotes.adapter as QuoteAdapter).add(text = selector)
        }
    }
}
