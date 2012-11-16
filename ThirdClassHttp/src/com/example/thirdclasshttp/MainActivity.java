package com.example.thirdclasshttp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    public void onClick(View view) {
    	AsyncTask<String,Void,String> task = new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				for(int i=0 ; i<params.length ; i++) {
					doReq(params[i]);
				}
				return null;
			}
    		
    	};
    }
    
    public void doReq(String url) {
    	HttpClient client = new DefaultHttpClient();
    	HttpGet get = new HttpGet("http://stock.daum.net/item/main.daum?code=035720");
    	HttpResponse res;
		try {
			res = client.execute(get);
	    	InputStream is = res.getEntity().getContent();
	    	//BufferedInputStream br = new BufferedInputStream(is);
	    	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
