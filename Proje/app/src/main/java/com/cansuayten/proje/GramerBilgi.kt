package com.cansuayten.proje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class GramerBilgi : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gramer_bilgi)
        //val text: TextView = findViewById(R.id.textView3) as TextView
        //val textView = findViewById<TextView>(R.id.textView3)
        val ListView = findViewById<ListView>(R.id.Liste)
        //val textViewValue = textView.text
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()


        db.collection("Notes").addSnapshotListener { snapshot, exception ->
            if(exception != null)
            {
                Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
            else{
                val arrayList: ArrayList<String> = ArrayList<String>()
                if(snapshot!=null)
                {
                    if(!snapshot.isEmpty)
                    {
                        val doc = snapshot.documents
                        for (document in doc) {
                            val baslik = document.get("notBaslik") as String
                            val negatif = document.get("notNegatif") as String
                            val negatifCumle = document.get("notNegatifCumle") as String
                            val pozitif = document.get("notPozitif") as String
                            val pozitifCumle = document.get("notPozitifCumle") as String
                            val soru = document.get("notSoru") as String
                            val soruCumle = document.get("notSoruCumle") as String
                            arrayList.add(baslik + "\n" + negatif + "\n" + negatifCumle + "\n" + pozitif + "\n" + pozitifCumle + "\n" + soru + "\n" + soruCumle + "\n\n")
                        }
                        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
                        ListView.adapter = adapter
                    }
                }
            }
        }
    }
}