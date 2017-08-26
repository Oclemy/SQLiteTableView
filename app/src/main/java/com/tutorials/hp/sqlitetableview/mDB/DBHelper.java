package com.tutorials.hp.sqlitetableview.mDB;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * - Created by Oclemy on for ProgrammingWizards Channel and http://www.camposha.info.
 * - DATABASE HELPER CLASS.
 * - EXTENDS SQLITE OPEN HELPER CLASS.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    /*
    1.RESPONSIBILITY: CREATES TABLE
    2. WE PASS SQLITEDATABASE AS A PARAMETER.
    3. WE DO IT INSIDE TRY CATCH BLOCK TO CATCH ANY ERRORS.
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
    1.UPGRADE TABLE
    2. WE PASS SQLITEDATABASE OBJECT,OLD VERSION AND NEW VERSION NUMBERS AS PARAMETER.
    3. WE CATCH SQLEXCEPTION ERRORS.
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
