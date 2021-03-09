package com.cansuayten.proje

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Byte.decode
import java.lang.Integer.decode
import java.lang.Long.decode


class CoktanSecmeli_Yeni : AppCompatActivity() {
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    var secenekler = Array<Int>(4){0}

    val kelime: ArrayList<String> = ArrayList<String>()
    val anlam: ArrayList<String> = ArrayList<String>()

     lateinit var cevap : String
     lateinit var b : String
     lateinit var c : String
     lateinit var d : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coktan_secmeli)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)
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
        var rb3 = findViewById<RadioButton>(R.id.radioButton3)
        var rb4 = findViewById<RadioButton>(R.id.radioButton4)
        if(rb3.isChecked) {
            randomSoru()
            var btnAcKardes = findViewById<Button>(R.id.btnAcKardes)
            btnAcKardes.isClickable = false
            btnAcKardes.visibility = View.INVISIBLE

        }
        else
        {
            randomSoru2()
            var btnAcKardes = findViewById<Button>(R.id.btnAcKardes)
            btnAcKardes.isClickable = false
            btnAcKardes.visibility = View.INVISIBLE
        }
        rb3.visibility=View.INVISIBLE
        rb4.visibility=View.INVISIBLE
    }
    fun sonraki(view: View)
    {
        var rb3 = findViewById<RadioButton>(R.id.radioButton3)
        var rb4 = findViewById<RadioButton>(R.id.radioButton4)
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)
        if(rb3.isChecked) {
            randomSoru()
        }
        else
        {
            randomSoru2()
        }
        val red = Color.parseColor("#C57575");
        rb_A.setBackgroundColor(red)
        rb_B.setBackgroundColor(red)
        rb_C.setBackgroundColor(red)
        rb_D.setBackgroundColor(red)
    }
    fun rbA(view: View)
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)

        if (rb_A.text.toString() == cevap)
        {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_A.setBackgroundColor(Color.GREEN)
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
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)
        if (rb_B.text.toString() == cevap)
        {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_B.setBackgroundColor(Color.GREEN)
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
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)
        if (rb_C.text.toString() == cevap)
        {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_C.setBackgroundColor(Color.GREEN)
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
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)
        if (rb_D.text.toString() == cevap) {
            Toast.makeText(this, "Helal sana reis!!!", Toast.LENGTH_LONG).show()
            rb_D.setBackgroundColor(Color.GREEN)
        } else {
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
    fun randomSoru()
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)

        var soru=(0..150).random()
        cevap = anlam[soru]
        b = anlam[(0..150).random()]
        c = anlam[(0..150).random()]
        d = anlam[(0..150).random()]

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
    fun randomSoru2()
    {
        var txtSoru = findViewById<TextView>(R.id.txtSoru)
        var rb_A = findViewById<Button>(R.id.btnSonraki5)
        var rb_B = findViewById<Button>(R.id.btnSonraki4)
        var rb_C = findViewById<Button>(R.id.btnSonraki3)
        var rb_D = findViewById<Button>(R.id.btnSonraki2)

        var soru=(0..150).random()
        cevap = kelime[soru]
        b = kelime[(0..150).random()]
        c = kelime[(0..150).random()]
        d = kelime[(0..150).random()]

        txtSoru.text = anlam[soru]//soru
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