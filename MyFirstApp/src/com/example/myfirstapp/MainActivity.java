package com.example.myfirstapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout 파일을 읽어서 적혀있는데로 뷰 클래스를 만들어서 윈도우에 붙이는 역할ㅓㅓ
        
        this.getIntent();
        if(getIntent().getAction().equals(Intent.ACTION_SEND)) {
        	Uri uri = (Uri) getIntent().getExtras().getParcelable(Intent.EXTRA_STREAM);
        	
        	ImageView iv = (ImageView) findViewById(R.id.imageView);
        	iv.setImageURI(uri);
        }
        
        Button btn = (Button)this.findViewById(R.id.testButton);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 액티비티 간의 이동
				// 컨텍스트는 왠만하면 액티비티로 짜면 된다
				Intent intent = new Intent(MainActivity.this, RedActivity.class);
				MainActivity.this.startActivity(intent);
			}
        	
        });
    }
    
    public void OnClickTestButton(View view) {
    	Toast.makeText(this, "눌렀다", 1000).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
