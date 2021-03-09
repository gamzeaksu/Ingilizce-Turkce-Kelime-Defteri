package com.cansuayten.proje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap

class Kelime_Ekle_Listele : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelime__ekle__listele)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
    }
    fun kelimeListele(view: View)
    {
        val ListView = findViewById<ListView>(R.id.adminKelimeListesi)
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
    fun kelimeEkle(view:View)
    {
        val txtKelime = findViewById<TextView>(R.id.txtKelime)
        val txtAnlami = findViewById<TextView>(R.id.txtAnlami)
        val anlami = txtAnlami.text.toString()
        val kelime = txtKelime.text.toString()
        if(anlami!="" && kelime!="") {
            val hm = HashMap<String, String>()
            hm["meaning"] = anlami
            hm["word"] = kelime

            db.collection("Words").document().set(hm).addOnSuccessListener {
                Toast.makeText(this, "Başarıyla eklendi.", Toast.LENGTH_LONG).show()
            }
                    .addOnFailureListener { Toast.makeText(applicationContext, "Hata.", Toast.LENGTH_LONG).show() }
        }
        else
            Toast.makeText(this, "Lütfen kelime-anlam eksiksiz giriniz.", Toast.LENGTH_LONG).show()
    }
}