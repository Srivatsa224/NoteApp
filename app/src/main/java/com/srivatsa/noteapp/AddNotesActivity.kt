package com.srivatsa.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_add_notes.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class AddNotesActivity : AppCompatActivity() {

    private lateinit var titleID:EditText
    private lateinit var descriptionET:EditText
    private lateinit var saveNotesBtn:Button
    private lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        //init views
        titleID=findViewById(R.id.etTitle)
        descriptionET=findViewById(R.id.etDescription)
        saveNotesBtn=findViewById(R.id.saveNotesButton)
        realm= Realm.getDefaultInstance()

        //onclick to save notes
        saveNotesBtn.setOnClickListener {
            //function
            addNotesToDB()
        }
    }

    private fun addNotesToDB() {
        try {

            //Auto Increment of ID
            realm.beginTransaction()
            val currentIdNumber:Number?=realm.where(Notes::class.java).max("id")
            val nextID:Int

            nextID=if(currentIdNumber==null){
                1
            }else{
                currentIdNumber.toInt() +1
            }

            val notes=Notes()
            notes.title=etTitle.text.toString()
            notes.description=etDescription.text.toString()
            notes.id=nextID

            //copy transaction and commit(copy to realm db)

            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()

            Toast.makeText(this,"Notes added successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()




        }

        catch (e:Exception){
            Toast.makeText(this,"Failed to add, $e", Toast.LENGTH_SHORT).show()


        }



    }
}
