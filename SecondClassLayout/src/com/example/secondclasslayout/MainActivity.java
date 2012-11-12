package com.example.secondclasslayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Spinner spin = (Spinner) findViewById(R.id.spinnerTest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
