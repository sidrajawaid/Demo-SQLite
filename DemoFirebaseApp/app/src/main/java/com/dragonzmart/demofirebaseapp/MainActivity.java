package com.dragonzmart.demofirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn1;
    //Firebase mRef;
    private Fi


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://demofirebaseapp-ac483.firebaseio.com/");
        ed1=(EditText) findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void signIn()
    {
        String username=ed1.getText().toString();
        String password=ed2.getText().toString();

    }
}
