package com.quran.islam.quran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

import static android.R.attr.key;

public class DetailByKey extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_by_key);

        textView = (TextView) findViewById(R.id.textView);

        Intent iin= getIntent(); Bundle bundle = iin.getExtras();

        if (bundle != null) {
            Set<String> keys = bundle.keySet();
            Iterator<String> it = keys.iterator();
            Log.e("","Dumping Intent start");
            while (it.hasNext()) {
                String key = it.next();
                String j = (String) bundle.get(key);
                textView.setText(j);
            }
            }
    }
}
