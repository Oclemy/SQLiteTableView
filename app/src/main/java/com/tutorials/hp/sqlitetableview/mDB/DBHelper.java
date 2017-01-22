package com.tutorials.hp.sqlitetableview.mDB;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Oclemy on 9/27/2016 for ProgrammingWizards Channel and http://www.camposha.info.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }
    /*
    CREATE TABLE
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(Constants.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /*
    UPGRADE TABLE
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL(Constants.DROP_TB);
            db.execSQL(Constants.CREATE_TB);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
