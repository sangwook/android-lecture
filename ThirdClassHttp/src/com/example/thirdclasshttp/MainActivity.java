package com.example.thirdclasshttp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	public static class Idol {
		public String title;
		public String desc;
		public int type = 0; // 0,1
		
		public int getLayoutId() {
			if(type==0) {
				return R.layout.custom_item;
			}
			else {
				return R.layout.custom_item2;
			}
		}
		
		public Idol(String title,String desc,int type) {
			this.title = title;
			this.desc = desc;
			this.type = type;
		}
	}
	
    public static class IdolAdapter extends BaseAdapter {
        	
        	private ArrayList<Idol> data = new ArrayList<MainActivity.Idol>();
        	private LayoutInflater inf;
        	public IdolAdapter(LayoutInflater inf) {
        		this.inf = inf;
        	}
        	
        	public void addIdol(Idol idol) {
        		data.add(idol);
        	}

			@Override
			public int getCount() {
				return data.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				Idol idol = data.get(position);
				
				if(convertView==null) {
					convertView = inf.inflate(idol.getLayoutId(),null);
				}
				
				if(idol.type == 0) {
					TextView textView = (TextView) convertView.findViewById(R.id.title);
					textView.setText(idol.title);
					
					TextView textView2 = (TextView) convertView.findViewById(R.id.desc);
					textView2.setText(idol.title);
				} else {
					TextView textView = (TextView) convertView.findViewById(R.id.title);
					textView.setText(idol.title);
				}
				return convertView;
			}
			
			public int getItemViewType(int position) {
				Idol idol = data.get(position);
				return idol.type;
			}
			
			public int getViewTypeCount() {
				return 2;
			}
        }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        String[] arr = new String[]{"abasdf","asdf"};
        IdolAdapter adapter = new IdolAdapter(getLayoutInflater());
        adapter.addIdol(new Idol("뷴류1","asdf",1));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("분류2","asdf",1));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        adapter.addIdol(new Idol("소녀시대","asdf",0));
        
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
