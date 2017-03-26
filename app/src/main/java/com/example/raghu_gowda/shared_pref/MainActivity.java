package com.example.raghu_gowda.shared_pref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Button button2;
    public EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        textView=(EditText) findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        //textView.setText(sharedPreferences.getString("username",""));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("username",textView.getText().toString());
                editor.apply();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startnewActivity();
            }


        });
    }

    private void startnewActivity() {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();

        SharedPreferences settings= PreferenceManager.getDefaultSharedPreferences(this);
        boolean red=settings.getBoolean("red",false);
        boolean green=settings.getBoolean("green",false);
        boolean blue=settings.getBoolean("blue",false);

        StringBuffer buffer=new StringBuffer("#");

        if(red){
            buffer.append("FF");
        }else{
            buffer.append("00");
        }

        if(green){
            buffer.append("FF");
        }else{
            buffer.append("00");
        }
        if(blue){
            buffer.append("FF");
        }else{
            buffer.append("00");
        }

        View v=findViewById(R.id.layout);
        v.setBackgroundColor(Color.parseColor(buffer.toString()));

    }



}