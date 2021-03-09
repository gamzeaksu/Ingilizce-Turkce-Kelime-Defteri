package com.cansuayten.proje
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class KelimeAlistirmalari : AppCompatActivity() {
    var kelimeK :Int = 0
    var i :Int = 0
    private lateinit var  mAuth : FirebaseAuth
    private lateinit var db : FirebaseFirestore

    val kelime: ArrayList<String> = ArrayList<String>()
    val anlam: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelime_alistirmalari)
        mAuth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()

        db.collection("Words").addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            } else {

                if (snapshot != null) {
                    if (!snapshot.isEmpty) {
                        val doc = snapshot.documents
                        var i=0
                        for (document in doc) {
                            if(i<200) {
                                val word = document.get("word") as String
                                val meaning = document.get("meaning") as String

                                kelime.add(word)
                                anlam.add(meaning)
                            }
                            i++
                        }

                    }
                }
            }
        }

    }
    fun kelimeAc(view: View)
    {
        var btnGoster = findViewById<Button>(R.id.btnGoster)
        btnGoster.visibility = View.INVISIBLE

        var rb1 = findViewById<RadioButton>(R.id.rbIngilizcedenTurkce)
        var rb2 = findViewById<RadioButton>(R.id.rbTurkceIngilizce)
        rb1.visibility= View.INVISIBLE
        rb2.visibility= View.INVISIBLE

        var btnSıradaki = findViewById<Button>(R.id.btnSiradaki)
        var btnKelime = findViewById<Button>(R.id.btnOne)
        kelimeK=(0..150).random()
        if(rb1.isChecked) {

            btnSıradaki.visibility = View.VISIBLE
            btnKelime.text = kelime[kelimeK]
        }
        else if(rb2.isChecked) {
            btnSıradaki.visibility = View.VISIBLE
            btnKelime.text = anlam[kelimeK]

        }
        else
        {
            Toast.makeText(this, "Radio buttonlardan birini seçiniz.", Toast.LENGTH_LONG).show()
        }

        btnSıradaki.visibility=View.VISIBLE
    }

    fun arkayaCevir(view:View) {
        var rb1 = findViewById<RadioButton>(R.id.rbIngilizcedenTurkce)
        var rb2 = findViewById<RadioButton>(R.id.rbTurkceIngilizce)
        var btnKelime = findViewById<Button>(R.id.btnOne)
        if (rb1.isChecked) {

            btnKelime.text = anlam[kelimeK]

        } else if (rb2.isChecked) {

            btnKelime.text = kelime[kelimeK]
        } else {
            Toast.makeText(this, "Radio buttonlardan birini seçiniz.", Toast.LENGTH_LONG).show()
        }

    }
    fun birSonraki(view:View)
    {
        var rb1 = findViewById<RadioButton>(R.id.rbIngilizcedenTurkce)
        var rb2 = findViewById<RadioButton>(R.id.rbTurkceIngilizce)
        var btnSıradaki = findViewById<Button>(R.id.btnSiradaki)
        var btnKelime = findViewById<Button>(R.id.btnOne)
        kelimeK=(0..150).random()
        if(rb1.isChecked) {
            btnSıradaki.visibility=View.VISIBLE
            btnKelime.text=kelime[kelimeK]
        }
        else if(rb2.isChecked) {
            btnSıradaki.visibility = View.VISIBLE
            btnKelime.text = anlam[kelimeK]
        }
        else {
            Toast.makeText(this, "Radio buttonlardan birini seçiniz.", Toast.LENGTH_LONG).show()
        }
    }
}