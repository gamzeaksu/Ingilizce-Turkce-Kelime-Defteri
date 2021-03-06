package com.cansuayten.proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Listele extends AppCompatActivity {
    private ListView VeriListele;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        VeriListele = (ListView) findViewById(R.id.VeriListele);
        //Listele();
        //dbEkle();
    }
    /*public void dbEkle()
    {

        String[] words = {"about","above","across","action","activity","actor","actress","add","address","adult","advice","afraid","after","afternoon","again","age","ago","agree","air","airport","all","also","always","amazing","and","angry","animal","another","answer","any","anyone","anything","apartment","apple","April","area","arm","around","arrive","art","article","artist","as","ask","at","August","aunt","autumn","away","baby",
                "back",    "bad",    "bag",    "ball",    "banana",    "band",    "bank",    "bath",    "bathroom",    "be",    "beach",    "beautiful",    "because",    "become",    "bed",    "bedroom",    "beer",    "before",    "begin",    "beginning",    "behind",    "believe",    "below",    "best",    "better",    "between",    "bicycle",    "big",    "bike",    "bill",    "bird",    "birthday",    "black",    "blog",    "blonde",    "blue",    "boat",    "body",    "book",    "boot",    "bored",    "boring",    "born",    "both",    "bottle",    "box",    "boy",    "boyfriend",    "bread",
                "break","breakfast","bring","brother","brown","build","building","bus","business","busy","but","butter","buy","by","bye","cafe","cake","call","camera","can","cannot","capital","car","card","career","carrot","carry","cat","CD","cent","centre","century","chair","change","chart","cheap","check","cheese","chicken","child","chocolate","choose","cinema","city","class","classroom","clean","climb","clock","close","clothes"};
        String[] meanings ={"hemen hemen [zf.]","??zerine [zf.]","kar????ya [zf.]","??al????ma [i.]","etkinlik [i.]","oyuncu [i.]","oyuncu [i.]","toplamak [f.]","hitap etmek [f.]","yeti??kin [i.]","nasihat [i.]","korkmu?? [s.]","sonra [zf.]","????leden sonra [i.]","bir daha [zf.]","ya?? [i.]","evvel [zf.]","ayn?? fikirde olmak [f.]","havaland??rmak [f.]","havaliman?? [i.]","t??m [i.]","ayr??ca [zf.]","hep [zf.]","??a????rt??c?? [s.]","ile [ba??.]","k??zm???? [s.]","hayvan [s.]","??b??r [s.]","yan??t vermek [f.]","lalettayin [s.]","hi?? kimse [zm.]","hi??bir ??ey [zm.]","daire [i.]","elma [i.]","nisan [i.]","alan [i.]","kol [i.]","sular??nda [zf.]","varmak [f.]","sanat [i.]","bent [i.]","artist [i.]","olarak [zf.]","soru sormak [f.]","??zere [zf.]","a??ustos [i.]","hala [i.]","g??z [i.]","uzak [s.]","yavru [i.]",
                "art [i.]",    "k??t?? [s.]" ,   "po??et [i.]",    "balo [i.]" ,   "muz [i.]" ,   "bant [i.]",    "banka [i.]" ,   "y??kanmak [f.]" ,   "tuvalet [i.]",    "bulunmak [f.]",    "sahil [i.]" ,   "g??zel [s.]" ,   "????nk?? [ba??.]" ,   "haline gelmek [f.]",    "yatak [i.]" ,   "yatak odas?? [i.]",    "bira [i.]",    "evvel [ed.]",    "ba??latmak [f.]" ,   "ba??lang???? [i.]"  ,  "ard??ndaki [s.]",    "inanmak [f.]" ,   "alttaki [s.]" ,   "en iyi [s.]" ,   "daha iyi [s.]",    "aras??nda [zf.]",    "bisiklet [i.]",    "iri [s.]" ,   "bisiklete binmek [f.]",    "senet [i.]" ,   "ku?? [i.]",    "ya?? g??n?? [i.]",    "siyahi [s.]"  ,  "web g??nl?????? " ,   "sar??????n [s.]" ,   "mavi [s.]",    "tekne [i.]",    "ceset [i.]",    "ay??rtmak [f.]" ,   "bot [i.]",    "s??k??lm???? [s.]",    "b??kt??r??c?? [s.]",    "do??an [s.]",    "her ikisi de [s.]" ,   "??i??e [i.]" ,   "kutu [i.]",    "delikanl?? [i.]",    "fl??rt [i.]" ,   "ekmek [i.]",
                "kopmak [f.]","kahvalt?? [i.]","getirmek [f.]","karde?? [i.]","kahverengi [s.]","in??a etmek [f.]","in??aat [i.]","otob??s [i.]","i??letme [i.]","i??lek [s.]","ancak [ba??.]","tereya???? [i.]","??smarlamak [f.]","ge??ecek bi??imde [zf.]","ast [i.]","kafe [i.]","kek [i.]","??a????rmak [f.]","foto??raf makinesi [i.]","olabilmek [f.]","edememek [f.]","sermaye [i.]","otomobil [i.]","kart [i.]","kariyer [i.]","k??z??l sa?? [i.]","ta????mak [f.]","kedi [i.]","d???? ??ap","sent [i.]","merkez [i.]","as??r [i.]","koltuk [i.]","de??i??mek [f.]","??izelge [i.]","ucuz [s.]","denetlemek [f.]","peynir [i.]","tavuk [i.]","evlat [i.]","??ikolata [i.]","se??mek [f.]","sinema [i.]","kent [i.]","ders [i.]","s??n??f [i.]","temizlemek [f.]","t??rmanmak [f.]","saat [i.]","kapamak [f.]","giysi [i.]"};
        for(int i=0;i<words.length;i++) {
            HashMap<String,String> hm = new HashMap<String,String>();
            hm.put("word", words[i]);
            hm.put("meaning", meanings[i]);
            db.collection("Words").document().set(hm).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Ba??ar??l?? Kay??t", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Anasayfa.class));
                    finish();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Hatal?? Kay??t", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }*/
    /*public void Listele()
    {
        KelimeTablo vt = new KelimeTablo(getApplicationContext());
        vt.VeriEkle();
        List<String> list = vt.KelimeListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);

       KelimeTablo vt = new KelimeTablo(getApplicationContext());
        SQLiteDatabase db=vt.getReadableDatabase();
        String[] getColumnName={"Word, Meanings"};
        Cursor imlec=db.query("Words", getColumnName, null, null, null, null, null);
        ListView listview=(ListView)findViewById(R.id.VeriListele);
        ArrayList<String> words=new ArrayList<String>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,words);

        while(imlec.moveToNext()){
            String word=imlec.getString(imlec.getColumnIndex("Word"));
            String meanings=imlec.getString(imlec.getColumnIndex("Meanings"));
            String word_meanings= word+ " "+meanings;
            words.add(word_meanings);

        }
        listview.setAdapter(adapter);
        imlec.close();
        db.close();

    }*/

}