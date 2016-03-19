package appewtc.masterung.inspection;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request SQLite
        myManage = new MyManage(this);

        //Add First Data
        addFirstData();


    }   // Main Method

    private void addFirstData() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.inspection_table, null);

        //Check Value
        if (cursor.getCount() == 0) {
            //Blank Table
            addToilet();
            addKitchen();
        }
        cursor.close();
    }   // addFirstData

    private void addKitchen() {

        String[] kitchenStrings = getResources().getStringArray(R.array.kitchen);
        for (int i = 0; i < kitchenStrings.length; i++) {
            myManage.addCatAndItem("ห้องครัว", kitchenStrings[i]);
        }   // for

    }   // addKitchen

    private void addToilet() {

        String[] toiletStrings = getResources().getStringArray(R.array.toilet);
        for (int i = 0; i < toiletStrings.length; i++) {
            myManage.addCatAndItem("ห้องน้ำ", toiletStrings[i]);
        }   // for

    }   // addToilet

}   // Main Class
