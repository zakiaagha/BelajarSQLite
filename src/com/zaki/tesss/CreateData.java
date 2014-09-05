package com.zaki.tesss;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateData extends Activity implements OnClickListener{
	//inisialiasi elemen-elemen pada layout
	private Button btntambah;
	@SuppressWarnings("unused")
	private EditText i_nim;
	@SuppressWarnings("unused")
	private EditText i_nama;
	@SuppressWarnings("unused")
	private EditText i_jurusan;
	@SuppressWarnings("unused")
	private EditText i_alamat;
	
	//inisialisasi kontroller
	@SuppressWarnings("unused")
	private DBDataSource dataSource;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createdata);
		
		btntambah = (Button) findViewById(R.id.btn_tambah);
		btntambah.setOnClickListener(this);
		i_nim=(EditText) findViewById(R.id.input_nim);
		i_nama = (EditText) findViewById(R.id.input_nama);
		i_jurusan = (EditText) findViewById(R.id.input_jurusan);
		i_alamat =(EditText) findViewById(R.id.input_alamat);
		
		//instansi kelas DBdatasource
		dataSource = new DBDataSource(this);
		
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
	}


}
