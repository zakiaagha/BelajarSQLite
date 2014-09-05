package com.zaki.tesss;

//deklarasi import package
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {
	/** deklarasi konstanta yang digunakan pada database**/
	public static final String TABLE_NAME = "data_mahasiswa";
	public static final String COLUMN_ID = "_nim";
	public static final String COLUMN_NAME = "nama";
	public static final String COLUMN_JURUSAN = "jurusan";
	public static final String COLUMN_ALAMAT = "alamat";
	public static final String db_name = "mahasiswa.db";
	public static final int db_version = 1;
	
	
	//perintah sql untuk membuat tabel database baru 
	private static final String db_create = "create table "
			+ TABLE_NAME + "(" 
			+ COLUMN_ID +"integer primary key autoincrement, "
			+ COLUMN_NAME +"varchar (50) not null, "
			+ COLUMN_JURUSAN +"varchar (50) not null, "
			+ COLUMN_ALAMAT +"varchar (50) not null); ";

	public DBhelper (Context context){
		super(context, db_name, null, db_version);
		
	}
	
	//eksekusi perintah SQL untuk membuat database baru
	public void onCreate(SQLiteDatabase db){
		db.execSQL(db_create);
	}
	
	//dijalankan apabila ingin mengupgrade database
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		Log.w(DBhelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}
	
}
