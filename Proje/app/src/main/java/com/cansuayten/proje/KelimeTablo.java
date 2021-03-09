package com.cansuayten.proje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KelimeTablo extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Dictionary.db";
    private static final String TABLE_NAME ="Words";
    private static String COL_ID = "Word_ID";
    private static String COL_WORD = "Word";
    private static String COL_MEANINGS = "Meanings";

    public KelimeTablo(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("CREATE TABLE " + TABLE_NAME+ "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_WORD+ " TEXT NOT NULL, "
                + COL_MEANINGS + " TEXT NOT NULL)");*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);*/
    }
    public List<String> KelimeListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getString(1) + " - " + cursor.getString(2));
            }
        }catch (Exception e){

        }
        db.close();
        return veriler;
    }
    /*String[] words = {"about","above","across","action","activity","actor","actress","add","address","adult","advice","afraid","after","afternoon","again","age","ago","agree","air","airport","all","also","always","amazing","and","angry","animal","another","answer","any","anyone","anything","apartment","apple","April","area","arm","around","arrive","art","article","artist","as","ask","at","August","aunt","autumn","away","baby",
            "back",    "bad",    "bag",    "ball",    "banana",    "band",    "bank",    "bath",    "bathroom",    "be",    "beach",    "beautiful",    "because",    "become",    "bed",    "bedroom",    "beer",    "before",    "begin",    "beginning",    "behind",    "believe",    "below",    "best",    "better",    "between",    "bicycle",    "big",    "bike",    "bill",    "bird",    "birthday",    "black",    "blog",    "blonde",    "blue",    "boat",    "body",    "book",    "boot",    "bored",    "boring",    "born",    "both",    "bottle",    "box",    "boy",    "boyfriend",    "bread",
            "break","breakfast","bring","brother","brown","build","building","bus","business","busy","but","butter","buy","by","bye","cafe","cake","call","camera","can","cannot","capital","car","card","career","carrot","carry","cat","CD","cent","centre","century","chair","change","chart","cheap","check","cheese","chicken","child","chocolate","choose","cinema","city","class","classroom","clean","climb","clock","close","clothes"};
    String[] meanings ={"hemen hemen [zf.]","üzerine [zf.]","karşıya [zf.]","çalışma [i.]","etkinlik [i.]","oyuncu [i.]","oyuncu [i.]","toplamak [f.]","hitap etmek [f.]","yetişkin [i.]","nasihat [i.]","korkmuş [s.]","sonra [zf.]","öğleden sonra [i.]","bir daha [zf.]","yaş [i.]","evvel [zf.]","aynı fikirde olmak [f.]","havalandırmak [f.]","havalimanı [i.]","tüm [i.]","ayrıca [zf.]","hep [zf.]","şaşırtıcı [s.]","ile [bağ.]","kızmış [s.]","hayvan [s.]","öbür [s.]","yanıt vermek [f.]","lalettayin [s.]","hiç kimse [zm.]","hiçbir şey [zm.]","daire [i.]","elma [i.]","nisan [i.]","alan [i.]","kol [i.]","sularında [zf.]","varmak [f.]","sanat [i.]","bent [i.]","artist [i.]","olarak [zf.]","soru sormak [f.]","üzere [zf.]","ağustos [i.]","hala [i.]","güz [i.]","uzak [s.]","yavru [i.]",
            "art [i.]",    "kötü [s.]" ,   "poşet [i.]",    "balo [i.]" ,   "muz [i.]" ,   "bant [i.]",    "banka [i.]" ,   "yıkanmak [f.]" ,   "tuvalet [i.]",    "bulunmak [f.]",    "sahil [i.]" ,   "güzel [s.]" ,   "çünkü [bağ.]" ,   "haline gelmek [f.]",    "yatak [i.]" ,   "yatak odası [i.]",    "bira [i.]",    "evvel [ed.]",    "başlatmak [f.]" ,   "başlangıç [i.]"  ,  "ardındaki [s.]",    "inanmak [f.]" ,   "alttaki [s.]" ,   "en iyi [s.]" ,   "daha iyi [s.]",    "arasında [zf.]",    "bisiklet [i.]",    "iri [s.]" ,   "bisiklete binmek [f.]",    "senet [i.]" ,   "kuş [i.]",    "yaş günü [i.]",    "siyahi [s.]"  ,  "web günlüğü " ,   "sarışın [s.]" ,   "mavi [s.]",    "tekne [i.]",    "ceset [i.]",    "ayırtmak [f.]" ,   "bot [i.]",    "sıkılmış [s.]",    "bıktırıcı [s.]",    "doğan [s.]",    "her ikisi de [s.]" ,   "şişe [i.]" ,   "kutu [i.]",    "delikanlı [i.]",    "flört [i.]" ,   "ekmek [i.]",
            "kopmak [f.]","kahvaltı [i.]","getirmek [f.]","kardeş [i.]","kahverengi [s.]","inşa etmek [f.]","inşaat [i.]","otobüs [i.]","işletme [i.]","işlek [s.]","ancak [bağ.]","tereyağı [i.]","ısmarlamak [f.]","geçecek biçimde [zf.]","ast [i.]","kafe [i.]","kek [i.]","çağırmak [f.]","fotoğraf makinesi [i.]","olabilmek [f.]","edememek [f.]","sermaye [i.]","otomobil [i.]","kart [i.]","kariyer [i.]","kızıl saç [i.]","taşımak [f.]","kedi [i.]","dış çap","sent [i.]","merkez [i.]","asır [i.]","koltuk [i.]","değişmek [f.]","çizelge [i.]","ucuz [s.]","denetlemek [f.]","peynir [i.]","tavuk [i.]","evlat [i.]","çikolata [i.]","seçmek [f.]","sinema [i.]","kent [i.]","ders [i.]","sınıf [i.]","temizlemek [f.]","tırmanmak [f.]","saat [i.]","kapamak [f.]","giysi [i.]"};


    public void VeriEkle(){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            for(int i=0;i<150;i++) {
                ContentValues cv = new ContentValues();
                cv.put(COL_WORD, words[i]);
                cv.put(COL_MEANINGS, meanings[i]);
                db.insert(TABLE_NAME, null, cv);
            }
        }catch (Exception e){
        }
        db.close();
    }*/
}
