package com.srivatsa.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class NotesAdapter (private val context: Context?,  private val notesList:RealmResults<Notes>)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.notes_rv_layout,parent,false)
        return RecyclerView.ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return notesList.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            }


}