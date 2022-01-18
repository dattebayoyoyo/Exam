package com.example.hohoho

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


 class RecycleViewFlowersAdapter(private val list: List<Flowers>) :
    RecyclerView.Adapter<RecycleViewFlowersAdapter.FlowersViewHolder>() {


    class FlowersViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView
        val textView: TextView
        val textView2: TextView
        val imageButton: ImageButton

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
            imageButton = itemView.findViewById(R.id.imageButton)

        }


        fun setData(flowers: Flowers) {

            imageButton.setOnClickListener {
                val dialogueBuilder = AlertDialog.Builder(itemView.context)
                    .setTitle("ყიდვა")
                    .setMessage("ნამდვილად გსურთ არჩეული თაიგულის შეძენა?")
                    .setPositiveButton("დიახ", ) { dialog, i ->
                        Toast.makeText(itemView.getContext(), "გთხოვთ დაიმახსოვროთ თაიგულის დასახელება, შესაძენად გადადით საინფორმაციო გვერდზე.", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .setNegativeButton("არა") { dialog, i ->
                        dialog.dismiss()
                    }
                    .setNeutralButton("გამოსვლა") { dialog, i ->
                        dialog.dismiss()
                    }.setCancelable(false)
                val alert = dialogueBuilder.create()
                alert.show()
            }

            Glide.with(itemView)
                .load(flowers.imageUrl)
                .into(imageView)

            textView.text = flowers.name
            textView2.text = flowers.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowersViewHolder {
      val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return FlowersViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: FlowersViewHolder, position: Int) {
        val person = list[position]
        holder.setData(person)
    }

    override fun getItemCount() = list.size

}
