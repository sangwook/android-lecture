package com.example.secondclasslayout;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
//        //SpinnerAdapter 는 구현해야 할게 너무 많으니까 일단 String이 들어가는 어댑터로 만듬
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_item);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_item);
//        adapter.add("ABC");
//        adapter.add("ABC");
//        adapter.add("ABC");
//        adapter.add("ABC");
//        adapter.add("ABC");
//        adapter.add("ABC");
//       
//        //arrayadapter는 텍스트뷰만 들어갈 수 있어서.
//        BaseAdapter adapter = new BaseAdapter() {
//
//			@Override
//			public int getCount() {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//
//			@Override
//			public Object getItem(int position) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public long getItemId(int position) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//
//			@Override
//			public View getView(int position, View convertView, ViewGroup parent) {
//				View view = MainActivity.this.getLayoutInflater().inflate(R.layout.custom_item, null);
//				TextView tv = (TextView) view.findViewById(android.R.id.text1);
//				return view;
//			}
//        }
//        
//        Spinner spin = (Spinner) findViewById(R.id.spinnerTest);
//        spin.setAdapter(adapter);
        
        TabHost myTab = (TabHost) findViewById(R.id.myTab);
        myTab.setup(getLocalActivityManager());
        TabSpec tabspec = myTab.newTabSpec("TAB1").setContent(new Intent(this,RedActivity.class)).setIndicator("TAB1");
        TabSpec tabspec2 = myTab.newTabSpec("TAB1").setContent(new Intent(this,RedActivity.class)).setIndicator("TAB1");
        myTab.addTab(tabspec);
        myTab.addTab(tabspec2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
