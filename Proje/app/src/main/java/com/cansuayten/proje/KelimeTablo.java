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
    String[] meanings ={"hemen hemen [zf.]","??zerine [zf.]","kar????ya [zf.]","??al????ma [i.]","etkinlik [i.]","oyuncu [i.]","oyuncu [i.]","toplamak [f.]","hitap etmek [f.]","yeti??kin [i.]","nasihat [i.]","korkmu?? [s.]","sonra [zf.]","????leden sonra [i.]","bir daha [zf.]","ya?? [i.]","evvel [zf.]","ayn?? fikirde olmak [f.]","havaland??rmak [f.]","havaliman?? [i.]","t??m [i.]","ayr??ca [zf.]","hep [zf.]","??a????rt??c?? [s.]","ile [ba??.]","k??zm???? [s.]","hayvan [s.]","??b??r [s.]","yan??t vermek [f.]","lalettayin [s.]","hi?? kimse [zm.]","hi??bir ??ey [zm.]","daire [i.]","elma [i.]","nisan [i.]","alan [i.]","kol [i.]","sular??nda [zf.]","varmak [f.]","sanat [i.]","bent [i.]","artist [i.]","olarak [zf.]","soru sormak [f.]","??zere [zf.]","a??ustos [i.]","hala [i.]","g??z [i.]","uzak [s.]","yavru [i.]",
            "art [i.]",    "k??t?? [s.]" ,   "po??et [i.]",    "balo [i.]" ,   "muz [i.]" ,   "bant [i.]",    "banka [i.]" ,   "y??kanmak [f.]" ,   "tuvalet [i.]",    "bulunmak [f.]",    "sahil [i.]" ,   "g??zel [s.]" ,   "????nk?? [ba??.]" ,   "haline gelmek [f.]",    "yatak [i.]" ,   "yatak odas?? [i.]",    "bira [i.]",    "evvel [ed.]",    "ba??latmak [f.]" ,   "ba??lang???? [i.]"  ,  "ard??ndaki [s.]",    "inanmak [f.]" ,   "alttaki [s.]" ,   "en iyi [s.]" ,   "daha iyi [s.]",    "aras??nda [zf.]",    "bisiklet [i.]",    "iri [s.]" ,   "bisiklete binmek [f.]",    "senet [i.]" ,   "ku?? [i.]",    "ya?? g??n?? [i.]",    "siyahi [s.]"  ,  "web g??nl?????? " ,   "sar??????n [s.]" ,   "mavi [s.]",    "tekne [i.]",    "ceset [i.]",    "ay??rtmak [f.]" ,   "bot [i.]",    "s??k??lm???? [s.]",    "b??kt??r??c?? [s.]",    "do??an [s.]",    "her ikisi de [s.]" ,   "??i??e [i.]" ,   "kutu [i.]",    "delikanl?? [i.]",    "fl??rt [i.]" ,   "ekmek [i.]",
            "kopmak [f.]","kahvalt?? [i.]","getirmek [f.]","karde?? [i.]","kahverengi [s.]","in??a etmek [f.]","in??aat [i.]","otob??s [i.]","i??letme [i.]","i??lek [s.]","ancak [ba??.]","tereya???? [i.]","??smarlamak [f.]","ge??ecek bi??imde [zf.]","ast [i.]","kafe [i.]","kek [i.]","??a????rmak [f.]","foto??raf makinesi [i.]","olabilmek [f.]","edememek [f.]","sermaye [i.]","otomobil [i.]","kart [i.]","kariyer [i.]","k??z??l sa?? [i.]","ta????mak [f.]","kedi [i.]","d???? ??ap","sent [i.]","merkez [i.]","as??r [i.]","koltuk [i.]","de??i??mek [f.]","??izelge [i.]","ucuz [s.]","denetlemek [f.]","peynir [i.]","tavuk [i.]","evlat [i.]","??ikolata [i.]","se??mek [f.]","sinema [i.]","kent [i.]","ders [i.]","s??n??f [i.]","temizlemek [f.]","t??rmanmak [f.]","saat [i.]","kapamak [f.]","giysi [i.]"};


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
