package com.cansuayten.proje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ListeYeni : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_yeni)
        //val text: TextView = findViewById(R.id.textView3) as TextView
        //val textView = findViewById<TextView>(R.id.textView3)

        //val textViewValue = textView.text

    }

    fun kelimeGit(view: View) {
        val ListView = findViewById<ListView>(R.id.Liste)
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        db.collection("Words").addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            } else {
                val arrayList: ArrayList<String> = ArrayList<String>()
                if (snapshot != null) {
                    if (!snapshot.isEmpty) {
                        val doc = snapshot.documents
                        for (document in doc) {
                            val word = document.get("word") as String
                            val meaning = document.get("meaning") as String

                            arrayList.add(word + "-" + meaning + "\n");
                        }
                        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
                        ListView.adapter = adapter
                    }
                }
            }
        }
    }
        fun listeGit(view: View) {
            val ListView = findViewById<ListView>(R.id.Liste)
            mAuth = FirebaseAuth.getInstance()
            db = FirebaseFirestore.getInstance()

            val guncelKullanici = mAuth.currentUser!!.email.toString()
            db.collection("Lists").addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
                } else {
                    val arrayList: ArrayList<String> = ArrayList<String>()
                    if (snapshot != null) {
                        if (!snapshot.isEmpty) {
                            val doc = snapshot.documents

                            for (document in doc) {

                                val word = document.get("terim") as String
                                val meaning = document.get("anlam") as String
                                val mail = document.get("mail") as String
                                if (mail == guncelKullanici) {
                                    arrayList.add(word + "-" + meaning + "\n");
                                }
                            }
                            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
                            ListView.adapter = adapter
                        }
                    }
                }
            }
        }
    }
