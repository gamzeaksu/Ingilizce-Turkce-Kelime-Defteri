package com.cansuayten.proje

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.set

class IstekVeSikayet : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_istek_ve_sikayet)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
    }
    fun istekVeSikayetEkle(view: View)
    {
        val txtSikayet = findViewById<TextView>(R.id.txtSikayet)
        val sikayet = txtSikayet.text.toString()
        if(sikayet!="") {
            val guncelKullanici = mAuth.currentUser!!.email.toString()
            val hm = HashMap<String, String>()
            hm["sikayet"] = sikayet
            hm["mail"] = guncelKullanici

            db.collection("IstekVeSikayet").document().set(hm).addOnSuccessListener {
                Toast.makeText(applicationContext, "Başarıyla gönderildi.", Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext, Anasayfa::class.java)
                startActivity(intent)
            }
                    .addOnFailureListener { Toast.makeText(applicationContext, "Hata.", Toast.LENGTH_LONG).show() }
        }
        else
            Toast.makeText(applicationContext, "Lütfen istek veya şikayetinizi giriniz.", Toast.LENGTH_LONG).show()
    }
}