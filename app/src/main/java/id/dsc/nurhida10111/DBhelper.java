package id.dsc.nurhida10111;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by athaya on 14/04/18.
 */

public class DBhelper extends SQLiteOpenHelper{
    private static final String TAG = "DbHelper";

    private static final String DATABASE_NAME = "tukangbakso";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_INPUT = "tabel_menu";

    private static final String ID = "id";
    private static final String NAMA_MENU = "nama_menu";
    private static final String HARGA = "harga";

    private static DBhelper dbHelper;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //membuat database
        String queryCreateTabelJadwal = "create table " +
                TABLE_INPUT +
                " (" +
                ID + " integer primary key autoincrement not null," +
                NAMA_MENU + " text," +
                HARGA + " text" +
                ");";

        sqLiteDatabase.execSQL(queryCreateTabelJadwal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int lama, int baru) {
        //update database apakah sudah ada belum
        if (lama != baru){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INPUT);
            onCreate(sqLiteDatabase);
        }
    }

    public static synchronized DBhelper getInstance(Context context){
        if (dbHelper == null){
            dbHelper = new DBhelper(context.getApplicationContext());
        }
        return dbHelper;
    }

    private DBhelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //insert menu
    public void insertMenu(id.dsc.nurhida10111.Menu menu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put(NAMA_MENU, menu.getNama());
            values.put(HARGA, menu.getHarga());

            sqLiteDatabase.insertOrThrow(TABLE_INPUT, null, values);
            sqLiteDatabase.setTransactionSuccessful();
            Log.d(TAG, "Berhasil Menambah");
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Untuk Menambah"+e);
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    //mendapatkan menu yang ada didatabase
    public List<Menu> getMenu(){
        List<Menu> jadwalList = new ArrayList<>();
        String JADWAL_QUERY = " SELECT * FROM "+ TABLE_INPUT;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(JADWAL_QUERY, null);

        try{
            if (cursor.moveToFirst()){
                do {
                    Menu menu = new Menu(
                            cursor.getString(cursor.getColumnIndex(ID)),
                            cursor.getString(cursor.getColumnIndex(NAMA_MENU)),
                            cursor.getString(cursor.getColumnIndex(HARGA)));

                    Log.d(ID, cursor.getString(cursor.getColumnIndex(ID)));
                    jadwalList.add(menu);
                }
                while (cursor.moveToNext());
            }
        } catch (SQLException e){
            Log.d(TAG, "Gagal Mendapat Data");
        } finally {
            if (cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }

        return jadwalList;
    }

    //menghapus baris di database
    public void deleteJadwal(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL("DELETE FROM " + TABLE_INPUT + " WHERE " + ID + " = '" + id + "'");
            sqLiteDatabase.setTransactionSuccessful();
            Log.d(TAG, "Berhasil Menghapus Data");
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Menghapus Data");
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    //update data pada database
    public void updateData(id.dsc.nurhida10111.Menu menu){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL("UPDATE " + TABLE_INPUT + " SET " +
                    NAMA_MENU + " = '" + menu.getNama() + "', " +
                    HARGA + " = '" + menu.getHarga() + "' WHERE " +
                    ID + " = '" + menu.getId() + "'");
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Update Data");
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }
}
