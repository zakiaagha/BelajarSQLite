package com.zaki.tesss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBDataSource {
	//inisialisasi SQlite Database
	private SQLiteDatabase db;
	
	//inisialisasi kelas helper
	private DBhelper dbhelper;
	
	//ambil semua nama kolom
	private String[] allColumns = { DBhelper.COLUMN_ID,
			DBhelper.COLUMN_NAME, DBhelper.COLUMN_JURUSAN, DBhelper.COLUMN_ALAMAT};
	
	//DBhelper diinstansi pada konstuktor 
	public DBDataSource(Context context) {
		dbhelper = new DBhelper(context);
		
	}
	
	//membuka sambungan baru ke database
	public void open() throws SQLException {
		db = dbhelper.getWritableDatabase();
		
	}
	
	//menutup sambungan
	public void close() {
		dbhelper.close();
	}
	
	//method untuk insert data mahasiswa ke database
	public Mahasiswa createmahasiswa(String nim, String nama, String jurusan, String alamat) {
		//membuat values 
		ContentValues values = new ContentValues();
		values.put(DBhelper.COLUMN_ID, nim);
		values.put(DBhelper.COLUMN_NAME, nama);
		values.put(DBhelper.COLUMN_JURUSAN, jurusan);
		values.put(DBhelper.COLUMN_ALAMAT, alamat);
		
		//eksekusi perintah  SQL
		long insertData = db.insert(DBhelper.TABLE_NAME, null, values);
		
		//memanggil perintah select menggunakan kursor untuk melihat data sudah masuk
		Cursor cursor = db.query(DBhelper.TABLE_NAME, allColumns, DBhelper.COLUMN_ID + "=" + insertData, null, null, null, null);
		
		//pindah ke data paling lama
		cursor.moveToFirst();
		
		//mengubah objek pada kursor pertama ke objek Mahasiswa
		Mahasiswa newMahasiswa = cursorToMahasiswa(cursor);
		
		//close kursor
		cursor.close();
		
		//mengembalikan data mahasiswa baru
		return newMahasiswa;
		
	}
	
	private Mahasiswa cursorToMahasiswa(Cursor cursor) {
		//buat objek baru
		Mahasiswa mhs = new Mahasiswa();
		
		//debug logcat
		Log.v("info", "The getLONG "+cursor.getLong(0));
		Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));
		
		//set atribut pada oobjek mhs dengan data kursor yang diambil dari database
		mhs.setNim(cursor.getLong(0));
		mhs.setNama(cursor.getString(1));
		mhs.setJurusan(cursor.getString(2));
		mhs.setAlamat(cursor.getString(3));
		
		//kembalikan objek mhs
		return mhs;
	}

}
