package com.example.heroapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.example.heroapplication.datasource.Hero

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_HERO = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Menerima Sata Pada Intent Parcelabe
        val dataHero = intent.getParcelableExtra<Hero>(KEY_HERO)
        findViewById<ImageView>(R.id.img_item_photo).setImageResource(dataHero?.photo!!)
        findViewById<TextView>(R.id.tv_item_name).text = dataHero.name
        findViewById<TextView>(R.id.tv_item_description).text = dataHero.description

        // Tombol Back pada Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Action Untuk Tombo Back DI ACRION BAR
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}