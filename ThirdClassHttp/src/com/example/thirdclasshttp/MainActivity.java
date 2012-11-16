package com.example.thirdclasshttp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String[] arr = new String[]{"abasdf","asdf"};
        ArrayAdapter<String> adapter = 
        		new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        this.setListAdapter(adapter);
    }
    
    
    public void onClick(View view) {
    	Log.e("sangwok.onclick","");
    	AsyncTask<String,Void,String> task = new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				String buf ="";
				for(int i=0 ; i<params.length ; i++) {
					buf += doReq(params[i]);
					Log.e("SANGWOOK",buf);
				}
				return buf;
			}
    		
			@Override
			protected void onPostExecute(String result) {
//				Pattern p = Pattern.compile("<em class=\"curPrice");
//				Matcher m = k
				//여기서 패턴 매칭해서. 다음 주가 가져와서.
				//Textview 의 텍스트를 바꾸는 작업이 있음
						
				Log.e("SANGWOOK-onPostExecute",result);
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
				super.onPostExecute(result);
			}
    	};
    	task.execute("http://stock.daum.net/item/main.daum?code=035720");
    }
    
    public String doReq(String url) {
    	HttpClient client = new DefaultHttpClient();
    	HttpGet get = new HttpGet(url);
    	HttpResponse res;
		try {
			res = client.execute(get);
	    	String content = EntityUtils.toString(res.getEntity(),"UTF-8");
	    	return content;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
