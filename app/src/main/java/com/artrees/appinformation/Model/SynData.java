package com.artrees.appinformation.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.artrees.appinformation.DB.DBSQLiteManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Artrees on 1/1/2016.
 */
public class SynData extends DBSQLiteManager {
    private int SynID;
    public String SynDate;

    public final static String tbl_SynTable = "SynData";
    public final static String col_SynID = "SynID";
    public final static String col_SynDate = "SynDate";

    public SynData(Context context) {
        super(context);
        this.getLastUpdated(context);
    }

    public void getLastUpdated(Context context) {
        String[] columns = { col_SynID, col_SynDate};

        super.init(context);

        Cursor c = super.getCursor(this.tbl_SynTable, columns, null, null);

        if (c.moveToFirst()){
            this.SynID = c.getInt(0);
            this.SynDate = c.getString(1);
        }

        super.CloseConnection();
    }

    public void setUpdate(Context context) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContentValues cv = new ContentValues();
        cv.put(this.col_SynDate, df.format(Calendar.getInstance().getTime()));

        super.init(context);
        super.Update(this.tbl_SynTable, cv, this.col_SynID + "=" + this.SynID);
        super.CloseConnection();
    }
}
