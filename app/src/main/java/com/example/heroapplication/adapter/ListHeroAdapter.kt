package com.example.heroapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.heroapplication.DetailActivity
import com.example.heroapplication.R
import com.example.heroapplication.datasource.Hero



class ListHeroAdapter(private val listhero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


        fun bind(hero: Hero) {
            imgPhoto.setImageResource(hero.photo)
            tvName.text = hero.name
            tvDescription.text = hero.description
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.KEY_HERO, hero)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listhero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        // Toast Ketika di Klik
        /* holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih " + listhero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        } */

        // Ini Kehalaman Detail
        holder.bind(listhero[position])
    }

    override fun getItemCount(): Int = listhero.size

}