package com.quran.islam.quran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button buttonForFullQuran;
    private Button buttonForKeyWordSearch;
    private Button buttonForAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonForFullQuran = (Button) findViewById(R.id.fullQuran);
        buttonForKeyWordSearch = (Button) findViewById(R.id.searchByKeyword);
        buttonForAboutUs = (Button) findViewById(R.id.aboutUs);


        ///button for quran
        buttonForFullQuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, FullQuranActivity.class);
                startActivity(i);
            }
        });


        ///button for searchByKeyword
        buttonForKeyWordSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, SearchByKeywordActivity.class);
                startActivity(i);
            }
        });

        ///butoon for about us
        buttonForAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( MainActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });
    }

}
