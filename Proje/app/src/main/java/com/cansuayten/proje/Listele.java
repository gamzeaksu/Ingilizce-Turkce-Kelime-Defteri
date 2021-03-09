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
        String[] meanings ={"hemen hemen [zf.]","üzerine [zf.]","karşıya [zf.]","çalışma [i.]","etkinlik [i.]","oyuncu [i.]","oyuncu [i.]","toplamak [f.]","hitap etmek [f.]","yetişkin [i.]","nasihat [i.]","korkmuş [s.]","sonra [zf.]","öğleden sonra [i.]","bir daha [zf.]","yaş [i.]","evvel [zf.]","aynı fikirde olmak [f.]","havalandırmak [f.]","havalimanı [i.]","tüm [i.]","ayrıca [zf.]","hep [zf.]","şaşırtıcı [s.]","ile [bağ.]","kızmış [s.]","hayvan [s.]","öbür [s.]","yanıt vermek [f.]","lalettayin [s.]","hiç kimse [zm.]","hiçbir şey [zm.]","daire [i.]","elma [i.]","nisan [i.]","alan [i.]","kol [i.]","sularında [zf.]","varmak [f.]","sanat [i.]","bent [i.]","artist [i.]","olarak [zf.]","soru sormak [f.]","üzere [zf.]","ağustos [i.]","hala [i.]","güz [i.]","uzak [s.]","yavru [i.]",
                "art [i.]",    "kötü [s.]" ,   "poşet [i.]",    "balo [i.]" ,   "muz [i.]" ,   "bant [i.]",    "banka [i.]" ,   "yıkanmak [f.]" ,   "tuvalet [i.]",    "bulunmak [f.]",    "sahil [i.]" ,   "güzel [s.]" ,   "çünkü [bağ.]" ,   "haline gelmek [f.]",    "yatak [i.]" ,   "yatak odası [i.]",    "bira [i.]",    "evvel [ed.]",    "başlatmak [f.]" ,   "başlangıç [i.]"  ,  "ardındaki [s.]",    "inanmak [f.]" ,   "alttaki [s.]" ,   "en iyi [s.]" ,   "daha iyi [s.]",    "arasında [zf.]",    "bisiklet [i.]",    "iri [s.]" ,   "bisiklete binmek [f.]",    "senet [i.]" ,   "kuş [i.]",    "yaş günü [i.]",    "siyahi [s.]"  ,  "web günlüğü " ,   "sarışın [s.]" ,   "mavi [s.]",    "tekne [i.]",    "ceset [i.]",    "ayırtmak [f.]" ,   "bot [i.]",    "sıkılmış [s.]",    "bıktırıcı [s.]",    "doğan [s.]",    "her ikisi de [s.]" ,   "şişe [i.]" ,   "kutu [i.]",    "delikanlı [i.]",    "flört [i.]" ,   "ekmek [i.]",
                "kopmak [f.]","kahvaltı [i.]","getirmek [f.]","kardeş [i.]","kahverengi [s.]","inşa etmek [f.]","inşaat [i.]","otobüs [i.]","işletme [i.]","işlek [s.]","ancak [bağ.]","tereyağı [i.]","ısmarlamak [f.]","geçecek biçimde [zf.]","ast [i.]","kafe [i.]","kek [i.]","çağırmak [f.]","fotoğraf makinesi [i.]","olabilmek [f.]","edememek [f.]","sermaye [i.]","otomobil [i.]","kart [i.]","kariyer [i.]","kızıl saç [i.]","taşımak [f.]","kedi [i.]","dış çap","sent [i.]","merkez [i.]","asır [i.]","koltuk [i.]","değişmek [f.]","çizelge [i.]","ucuz [s.]","denetlemek [f.]","peynir [i.]","tavuk [i.]","evlat [i.]","çikolata [i.]","seçmek [f.]","sinema [i.]","kent [i.]","ders [i.]","sınıf [i.]","temizlemek [f.]","tırmanmak [f.]","saat [i.]","kapamak [f.]","giysi [i.]"};
        for(int i=0;i<words.length;i++) {
            HashMap<String,String> hm = new HashMap<String,String>();
            hm.put("word", words[i]);
            hm.put("meaning", meanings[i]);
            db.collection("Words").document().set(hm).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(), "Başarılı Kayıt", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Anasayfa.class));
                    finish();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Hatalı Kayıt", Toast.LENGTH_LONG).show();
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