package com.example.secondclasslayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        //SpinnerAdapter �� �����ؾ� �Ұ� �ʹ� �����ϱ� �ϴ� String�� ���� ����ͷ� ����
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_item);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_item);
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
       
        //arrayadapter�� �ؽ�Ʈ�丸 �� �� �־.
        BaseAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 0;
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
				View view = MainActivity.this.getLayoutInflater().inflate(R.layout.custom_item, null);
				TextView tv = (TextView) view.findViewById(android.R.id.text1);
				return view;
			}
        }
        
        Spinner spin = (Spinner) findViewById(R.id.spinnerTest);
        spin.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
