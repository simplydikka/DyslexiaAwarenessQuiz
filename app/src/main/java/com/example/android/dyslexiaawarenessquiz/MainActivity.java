package com.example.android.dyslexiaawarenessquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dyslexiaWhatIsButton = (Button) findViewById(R.id.dyslexia_what_is_button);
        dyslexiaWhatIsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DyslexiaWhatIsActivity.class));
            }
        });

        Button dyslexiaTestButton = (Button) findViewById(R.id.dyslexia_test_button);
        dyslexiaTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DyslexiaTestActivity.class));
            }
        });

        Button dyscalculiaWhatIsButton = (Button) findViewById(R.id.dyscalculia_what_is_button);
        dyscalculiaWhatIsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DyscalculiaWhatIsActivity.class));
            }
        });

        Button dyscalculiaTestButton = (Button) findViewById(R.id.dyscalculia_test_button);
        dyscalculiaTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DyscalculiaTestActivity.class));
            }
        });

        Button dysgraphiaWhatIsButton = (Button) findViewById(R.id.dysgraphia_what_is_button);
        dysgraphiaWhatIsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DysgraphiaWhatIsActivity.class));
            }
        });

        Button dysgraphiaTestButton = (Button) findViewById(R.id.dysgraphia_test_button);
        dysgraphiaTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DysgraphiaTestActivity.class));
            }
        });

        Button pullList = (Button) findViewById(R.id.pullList);
        pullList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PullListActivity.class));
            }
        });


    }

}

