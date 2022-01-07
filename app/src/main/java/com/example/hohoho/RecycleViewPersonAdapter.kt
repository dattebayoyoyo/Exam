package com.example.hohoho

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecycleViewPersonAdapter(private val list: List<com.example.hohoho.Person>):
    RecyclerView.Adapter<RecycleViewPersonAdapter.PersonViewHolder>() {


    class PersonViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView
        val textView: TextView
        val textView2: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
        }

        fun setData(person: Person){
            Glide.with(itemView)
                .load(person.imageUrl)
                .into(imageView)

            textView.text = person.name
            textView2.text = person.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
      val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.activity_fragment1, parent, false)
        return PersonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = list[position]
        holder.setData(person)
    }

    override fun getItemCount() = list.size

}