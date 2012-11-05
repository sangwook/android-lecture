package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BlueActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue); //layout ������ �о �����ִµ��� �� Ŭ������ ���� �����쿡 ���̴� ���Ҥä�
        Button btn = (Button)this.findViewById(R.id.testButton);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��Ƽ��Ƽ ���� �̵�
				// ���ؽ�Ʈ�� �ظ��ϸ� ��Ƽ��Ƽ�� ¥�� �ȴ�
				Intent intent = new Intent(BlueActivity.this, RedActivity.class);
				BlueActivity.this.startActivity(intent);
			}
        	
        });
    }
    
    public void OnClickTestButton(View view) {
    	Toast.makeText(this, "������", 1000).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
