package com.example.contactsFinal.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsFinal.Contact
import com.example.contactsFinal.R

class ContactListAdapter(listen: OnButtonClickListener) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var listener : OnButtonClickListener = listen
    private var contactsList: List<Contact>? = null

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        contactsList.let {
            viewHolder.nameTextView.text = it!![i].contactName
            viewHolder.phoneTextView.text = it[i].contactPhone
            viewHolder.deleteImg.setImageResource(R.drawable.deletebtn)
            viewHolder.deleteImg.setOnClickListener {
                val data: Contact = contactsList!![i]
               listener.onButtonClick(data)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.card_layout, viewGroup, false)
        return ViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: List<Contact>) {
        contactsList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactsList == null) 0 else contactsList!!.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.contactName)
        var phoneTextView: TextView = itemView.findViewById(R.id.contactPhone)
        var deleteImg: ImageView = itemView.findViewById(R.id.deleteBtn)
    }
    interface OnButtonClickListener{
        fun onButtonClick(data : Contact)
    }
}