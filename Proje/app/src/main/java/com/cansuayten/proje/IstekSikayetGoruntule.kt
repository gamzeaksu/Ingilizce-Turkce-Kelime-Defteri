package com.cansuayten.proje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class IstekSikayetGoruntule : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_istek_sikayet_goruntule)
        val listView = findViewById<ListView>(R.id.listView)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()


        db.collection("IstekVeSikayet").addSnapshotListener { snapshot, exception ->
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
                            val kullanici = document.get("mail") as String
                            val sikayet = document.get("sikayet") as String

                            arrayList.add("Kullanıcı mail:" + kullanici + "\nİstek-Şikayet:" + sikayet)
                        }
                        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
                        listView.adapter = adapter
                    }
                }
            }
        }
    }
}