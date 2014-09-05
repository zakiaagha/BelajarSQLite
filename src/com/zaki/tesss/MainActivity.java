package com.zaki.tesss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button btnTambah;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTambah = (Button) findViewById(R.id.button_tambah);
        btnTambah.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
    	{
    	case R.id.button_tambah :
    		Intent i = new Intent(this, CreateData.class);
    		startActivity(i);
    		break;
    	}
	}
}
