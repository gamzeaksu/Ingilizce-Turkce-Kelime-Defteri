package com.cansuayten.proje

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.set
//HAFTALIK 1.LER ADMİN TARAFINDAN AÇIKLANACAK ÖNÜMÜZDEKİ SÜRÜMLERE BAKALIM
class Yarisma : AppCompatActivity() {

    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    var secenekler = Array<Int>(4){0}

    val kelime: ArrayList<String> = ArrayList<String>()
    val anlam: ArrayList<String> = ArrayList<String>()
    var count : Int = 0
    var i : Int = 0
    lateinit var cevap : String
    lateinit var b : String
    lateinit var c : String
    lateinit var d : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yarisma)

        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)

        db.collection("Words").addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {
                        val doc = snapshot.documents
                        for (document in doc) {
                            val word = document.get("word") as String
                            val meaning = document.get("meaning") as String

                            kelime.add(word)
                            anlam.add(meaning)
                        }

                    }
                }
            }
        }
    }

    fun acKardes(view: View)
    {
        randomSoru(0)
        var btnAcKardes = findViewById<Button>(R.id.btnAc)
        btnAcKardes.isClickable = false
        btnAcKardes.visibility = View.INVISIBLE
    }

    fun rbA(view: View)
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)

        if (rb_A.text.toString() == cevap)
        {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_A.setBackgroundColor(Color.GREEN)
            count += 10
        }
        else {
            if (rb_B.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_A.setBackgroundColor(Color.RED)
                rb_B.setBackgroundColor(Color.GREEN)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            } else if (rb_C.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.GREEN)
                rb_D.setBackgroundColor(Color.RED)
            }
            else {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.GREEN)
            }
        }

    }
    fun rbB(view: View)
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)
        if (rb_B.text.toString() == cevap)
        {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_B.setBackgroundColor(Color.GREEN)
            count += 10
        }
        else {
            if (rb_A.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_A.setBackgroundColor(Color.GREEN)
                rb_B.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            } else if (rb_C.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.GREEN)
                rb_D.setBackgroundColor(Color.RED)
            }
            else {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.GREEN)
            }
        }
    }
    fun rbC(view: View)
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)
        if (rb_C.text.toString() == cevap) {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_C.setBackgroundColor(Color.GREEN)
            count += 10
        }
        else {
            if (rb_A.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_A.setBackgroundColor(Color.GREEN)
                rb_B.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            } else if (rb_B.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.GREEN)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            }
            else {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.GREEN)
            }
        }

    }
    fun rbD(view: View) {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)
        if (rb_D.text.toString() == cevap) {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_D.setBackgroundColor(Color.GREEN)
            count += 10
        }
        else {
            if (rb_A.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_A.setBackgroundColor(Color.GREEN)
                rb_B.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            } else if (rb_B.text.toString() == cevap) {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.GREEN)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.RED)
                rb_D.setBackgroundColor(Color.RED)
            }
            else {
                Toast.makeText(this, "Opps.. Yanlış cevap!!!", Toast.LENGTH_LONG).show()
                rb_B.setBackgroundColor(Color.RED)
                rb_A.setBackgroundColor(Color.RED)
                rb_C.setBackgroundColor(Color.GREEN)
                rb_D.setBackgroundColor(Color.RED)
            }
        }
    }
    fun sonraki(view: View)
    {
        var btnAc = findViewById<Button>(R.id.btnAc)
        var btnNext = findViewById<Button>(R.id.btnNext)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)
        i++
        randomSoru(i)
        if(i == 10)
        {
            btnAc.visibility = View.VISIBLE
            btnAc.text = "YARIŞMA SONA ERMİŞTİR...\n PUANINIZ: "+count
            btnNext.visibility = View.INVISIBLE

            val guncel = mAuth.currentUser!!.email.toString()
            mAuth = FirebaseAuth.getInstance()
            db = FirebaseFirestore.getInstance()
            val hm = HashMap<String,String>()
            hm["mail"] = guncel
            hm["score"] = count.toString()

            db.collection("Scores").document().set(hm).addOnSuccessListener {
                Toast.makeText(this, "Başarıyla eklendi.", Toast.LENGTH_LONG).show()
            }
                    .addOnFailureListener { Toast.makeText(applicationContext, "Hata.", Toast.LENGTH_LONG).show() }
        }
        val red = Color.parseColor("#C57575");
        rb_A.setBackgroundColor(red)
        rb_B.setBackgroundColor(red)
        rb_C.setBackgroundColor(red)
        rb_D.setBackgroundColor(red)

    }
    fun randomSoru(number: Int)
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnA)
        var rb_B = findViewById<Button>(R.id.btnB)
        var rb_C = findViewById<Button>(R.id.btnC)
        var rb_D = findViewById<Button>(R.id.btnD)

        var soru=number
        cevap = anlam[soru]
        b = anlam[(number +5)%10]
        c = anlam[(number +8)%10]
        d = anlam[(number +9)%10]

        txtSoru.text = kelime[soru]//soru
        val cevapindis = (0..3).random()
        if(cevapindis == 0)
        {
            rb_A.text = cevap
            rb_B.text = b
            rb_C.text = c
            rb_D.text = d
        }
        else if(cevapindis == 1)
        {
            rb_A.text = b
            rb_B.text = cevap
            rb_C.text = c
            rb_D.text = d
        }
        else if(cevapindis == 2)
        {
            rb_C.text = cevap
            rb_A.text = c
            rb_B.text = b
            rb_D.text = d
        }
        else
        {
            rb_D.text = cevap
            rb_A.text = d
            rb_B.text = b
            rb_C.text = c

        }
    }


}