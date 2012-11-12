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
       
        //SpinnerAdapter �� �����ؾ� �Ұ� �ʹ� �����ϱ� �ϴ� String�� ���� ����ͷ� ����
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
