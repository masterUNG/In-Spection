package appewtc.masterung.inspection;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    public void clickKitchen(View view) {

        int intIcon = R.drawable.build10;   //  รูปของห้องครัว
        moveToShowListView(getResources().getString(R.string.kitchen), intIcon);

    }   // clickKitchen

    public void clickToilet(View view) {

        int intIcon = R.drawable.build3; // รูปของห้องน้ำ
        moveToShowListView(getResources().getString(R.string.toilet), intIcon);

    }   // clickToilet

    private void moveToShowListView(String strChoose, int intIcon) {
        Intent intent = new Intent(MainActivity.this, InSpectionList.class);
        intent.putExtra("Title", strChoose);
        intent.putExtra("Icon", intIcon);
        startActivity(intent);
    }

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
