package com.tutorials.hp.sqlitetableview.mDB;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Space;


import com.tutorials.hp.sqlitetableview.mModel.Spacecraft;

import java.util.ArrayList;

/**
 * Created by Oclemy on 9/27/2016 for ProgrammingWizards Channel and http://www.camposha.info.
 */
public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    /*
    1. INITIALIZE DB HELPER AND PASS IT A CONTEXT

     */
    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }


    /*
    SAVE DATA TO DB
     */
    public boolean saveSpacecraft(Spacecraft spacecraft) {
        try {
            db = helper.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put(Constants.NAME, spacecraft.getName());
            cv.put(Constants.PROPELLANT, spacecraft.getPropellant());
            cv.put(Constants.DESTINATION, spacecraft.getDestination());


            long result = db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);
            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.close();
        }

        return false;
    }

    /*
     1. RETRIEVE SPACECRAFTS FROM DB AND POPULATE ARRAYLIST
     2. RETURN THE LIST
     */

    public ArrayList<Spacecraft> retrieveSpacecrafts()
    {
        ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

        String[] columns={Constants.ROW_ID,Constants.NAME,Constants.PROPELLANT,Constants.DESTINATION};

        try
        {
            db = helper.getWritableDatabase();
            Cursor c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);

            Spacecraft s;

            if(c != null)
            {
                while (c.moveToNext())
                {
                    String s_name=c.getString(1);
                    String s_propellant=c.getString(2);
                    String s_destination=c.getString(3);


                    s=new Spacecraft();
                    s.setName(s_name);
                    s.setPropellant(s_propellant);
                    s.setDestination(s_destination);

                    spacecrafts.add(s);
                }
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }


        return spacecrafts;
    }

}
