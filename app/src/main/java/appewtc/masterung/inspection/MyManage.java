package appewtc.masterung.inspection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 3/17/16 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;

    public static final String inspection_table = "inspectionTABLE";
    public static final String column_id = "_id";
    public static final String column_Category = "Category";
    public static final String column_Item = "Item";
    public static final String column_Status = "Status";
    public static final String column_Date = "Date";
    public static final String column_Operator = "Operator";


    public MyManage(Context context) {

        //Create & Connected SQLite
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor

    public long addCatAndItem(String strCategory,
                              String strItem) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Category, strCategory);
        contentValues.put(column_Item, strItem);

        return writeSqLiteDatabase.insert(inspection_table, null, contentValues);
    }


}   // Main Class
