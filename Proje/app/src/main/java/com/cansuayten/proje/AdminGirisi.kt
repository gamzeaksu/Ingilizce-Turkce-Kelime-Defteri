package com.cansuayten.proje

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AdminGirisi : AppCompatActivity() {
    private var email: EditText? = null
    private  var sifre:EditText? = null
    //private val btnAdminGiris: Button? = null
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_girisi)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
        email = findViewById<View>(R.id.txtEmail) as EditText
        sifre = findViewById<View>(R.id.editTextTextPassword1) as EditText
    }

    fun check(mail: String, pass: String) {
        val mailText = email?.text.toString()
        val sifreText = sifre?.text.toString()
        if(mail == mailText && pass == sifreText)
        {
            val intent = Intent(applicationContext, Admin::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "Hatalı Giriş", Toast.LENGTH_LONG).show();
        }
    }
    fun admin(view:View)
    {
        db.collection("Admin").addSnapshotListener { snapshot, exception ->
            if(exception != null)
            {
                Toast.makeText(this,exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
            else{
                val txtMail = findViewById<TextView>(R.id.txtEmail)
                val txtSifre = findViewById<TextView>(R.id.editTextTextPassword1)
                val email = txtMail.text.toString()
                val sifre = txtSifre.text.toString()
                if(snapshot!=null)
                {
                    if(!snapshot.isEmpty)
                    {
                        val doc = snapshot.documents
                        for (document in doc) {
                            val mail = document.get("adminMail") as String
                            val sifre1 = document.get("adminSifre") as String
                            //check(mail,sifre1)
                            //arrayMail.add(mail);
                            //arraySifre.add(sifre1);
                            if(mail==email && sifre==sifre1)
                            {
                                val intent = Intent(applicationContext, Admin::class.java)
                                startActivity(intent)
                            }
                            else
                            {
                                Toast.makeText(this, "Hatalı Giriş", Toast.LENGTH_LONG).show();
                            }

                        }

                    }
                }
            }
        }
    }
}