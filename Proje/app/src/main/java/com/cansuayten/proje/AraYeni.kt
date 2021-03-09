package com.cansuayten.proje

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.set

class AraYeni : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    public val words: ArrayList<String> = ArrayList<String>()
    public val meanings: ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ara_yeni)
        //val text: TextView = findViewById(R.id.textView3) as TextView
        //val textView = findViewById<TextView>(R.id.textView3)
        //val ListView = findViewById<ListView>(R.id.Liste)
        //val textViewValue = textView.text
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()



        db.collection("Words").addSnapshotListener { snapshot, exception ->
            if(exception != null)
            {
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
            else{
                val arrayList: ArrayList<String> = ArrayList<String>()
                if(snapshot!=null)
                {
                    if(!snapshot.isEmpty)
                    {
                        val doc = snapshot.documents
                        for (document in doc) {
                            val word = document.get("word") as String
                            val meaning = document.get("meaning") as String

                            arrayList.add(word + "-" + meaning + "\n")
                            words.add(word)
                            meanings.add(meaning)
                        }
                        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
                        //ListView.adapter = adapter
                    }
                }
            }
        }
    }
    fun ara2(view: View)
    {
        val txtTerim = findViewById<TextView>(R.id.txtTerim)
        val txtAnlam = findViewById<TextView>(R.id.txtAnlam)
        val terim = txtTerim.text.toString()
        var count=0
        for (i in words)
        {
            if(i==terim)
            {
                txtAnlam.text=meanings[count].toString()
            }
            else {
                count++
            }
        }

    }
    fun ekle2(view: View)
    {
        val txtTerim = findViewById<TextView>(R.id.txtTerim)
        val txtAnlam = findViewById<TextView>(R.id.txtAnlam)
        val terim = txtTerim.text.toString()
        val anlam = txtAnlam.text.toString()
        val guncelKullanici = mAuth.currentUser!!.email.toString()
        val hm = HashMap<String, String>()
        hm["terim"] = terim
        hm["anlam"] = anlam
        hm["mail"] =guncelKullanici

        db.collection("Lists").document().set(hm).addOnSuccessListener {
            Toast.makeText(applicationContext, "Başarılı Kayıt", Toast.LENGTH_LONG).show()
            startActivity(Intent(applicationContext, Anasayfa::class.java))
            finish()
        }
                .addOnFailureListener { Toast.makeText(applicationContext, "Hatalı Kayıt", Toast.LENGTH_LONG).show() }

    }
}