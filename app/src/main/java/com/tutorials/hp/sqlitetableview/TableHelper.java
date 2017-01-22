package com.tutorials.hp.sqlitetableview;

import android.content.Context;
import android.widget.Toast;

import com.tutorials.hp.sqlitetableview.mDB.DBAdapter;
import com.tutorials.hp.sqlitetableview.mModel.Spacecraft;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by Oclemy on 12/1/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class TableHelper {



    Context c;

    private String[] spaceProbeHeaders={"Name","Propellant","Destination"};
    private String[][] spaceProbes;

    public TableHelper(Context c) {
        this.c = c;
    }

    public String[] getSpaceProbeHeaders()
    {
        return spaceProbeHeaders;
    }


    public  String[][] getSpaceProbes()
    {
        ArrayList<Spacecraft> spacecrafts=new DBAdapter(c).retrieveSpacecrafts();
        Spacecraft s;

        spaceProbes= new String[spacecrafts.size()][3];

        for (int i=0;i<spacecrafts.size();i++) {

             s=spacecrafts.get(i);

            spaceProbes[i][0]=s.getName();
            spaceProbes[i][1]=s.getPropellant();
            spaceProbes[i][2]=s.getDestination();
        }

        return spaceProbes;





    }
}





