package com.dragonzmart.demofirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn;
    Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        final HashMap<String,String> dataset=new HashMap<String, String>();
        mRootRef=new Firebase("https://demofirebaseapp-ac483.firebaseio.com/User");
        ed=findViewById(R.id.editText);
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataset.put("Keyword",ed.getText().toString());
                dataset.put("Contact",ed.getText().toString());
                dataset.put("Number",ed.getText().toString());
                dataset.put("IP",ed.getText().toString());
                dataset.put("Region",ed.getText().toString());
                mRootRef.push().setValue(dataset);

            }
        });
    }
}
