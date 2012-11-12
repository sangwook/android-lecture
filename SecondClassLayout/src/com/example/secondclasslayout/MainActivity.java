package com.example.secondclasslayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        //SpinnerAdapter 는 구현해야 할게 너무 많으니까 일단 String이 들어가는 어댑터로 만듬
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_item);
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        adapter.add("ABC");
        Spinner spin = (Spinner) findViewById(R.id.spinnerTest);
        spin.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
