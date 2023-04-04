package com.example.card_assignment

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val titles: List<Int>, private val details: List<Int>, private val images: List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return Data.titles.size
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = Data.titles[titles[i]]
        viewHolder.itemDetail.text = Data.details[details[i]]
        viewHolder.itemImage.setImageResource(Data.images[images[i]])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                val i = Intent(v.context, MainActivity2::class.java)
                i.putExtra("title", titles[adapterPosition])
                i.putExtra("detail", details[adapterPosition])
                i.putExtra("image", images[adapterPosition])
                ContextCompat.startActivity(v.context, i, null)
            }
        }
    }
}
//            val itemView = findViewById<View>(R.id.View)
//            itemView.setOnClickListener {
//                val intent = Intent(this, MainActivity2::class.java)
//                startActivity(intent)
//                ContextCompat.startActivity(v.context, i, null)
//            }


//            itemView.setOnClickListener { v: View  ->
//                var position: Int = getAdapterPosition()
//
//                Snackbar.make(v, "Click detected on item $position",
//                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
//            }