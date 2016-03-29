package com.artrees.appinformation.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.artrees.appinformation.Model.SynData;

/**
 * Created by Artrees on 12/31/2015.
 */
public class DBSQLiteManager extends SQLiteOpenHelper {
    public final static String _DATABASE_NAME = "database";
    public final static int _DATABASE_VERSION = 1;

    protected static DBSQLiteManager instance = null;
    protected static SQLiteDatabase database = null;

    public DBSQLiteManager(Context context) {
        super(context, _DATABASE_NAME, null, _DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Table and Insert new record necessary
        db.execSQL("CREATE TABLE IF NOT EXISTS " + SynData.tbl_SynTable + " (" +
                    "SynID INTEGER primary key autoincrement, " +
                    "SynDate DATETIME NOT NULL)");

        db.execSQL("INSERT INTO " + SynData.tbl_SynTable + "(" + SynData.col_SynDate + ") VALUES(datetime())");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SynData.tbl_SynTable);
        onCreate(db);
    }

    public void init(Context context) {
        if (instance == null) {
            instance = new DBSQLiteManager(context);
        }
    }

    public SQLiteDatabase getDatabase() {
        if (null == database) {
            database = instance.getWritableDatabase();
        }
        return database;
    }

    public void CloseConnection() {
        if (null != database && database.isOpen()) {
            database.close();
        }
        database = null;
        instance = null;
    }

    public Cursor getCursor(String TableName, String[] columns, String where, String orders) {
        return getDatabase().query(TableName, columns, where, null, null, null, orders);
    }

    public int Update(String TableName, ContentValues ColumnsUpdate, String Condition ) {
        return getDatabase().update(TableName, ColumnsUpdate, Condition, null);
    }
}
