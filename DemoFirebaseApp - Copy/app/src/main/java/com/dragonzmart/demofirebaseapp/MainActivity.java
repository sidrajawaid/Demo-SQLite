package com.dragonzmart.demofirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn;
    TextView tv1;
    Button btn1;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://demofirebaseapp-ac483.firebaseio.com/");
        ed=findViewById(R.id.editText);
        btn=findViewById(R.id.button2);
        tv1=(TextView)findViewById(R.id.textview1);
        btn1=findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild_1=mRef.child("Keyword");
                mRefChild_1.setValue(ed.getText().toString());
                Firebase mRefChild_2=mRef.child("Number");
                mRefChild_2.setValue(ed.getText().toString());
                Firebase mRefChild_3=mRef.child("ContactList");
                mRefChild_3.setValue(ed.getText().toString());
                Firebase mRefChild_4=mRef.child("IP");
                mRefChild_4.setValue(ed.getText().toString());
                Firebase mRefChild_5=mRef.child("Region");
                mRefChild_5.setValue(ed.getText().toString());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Map<String,String> map=dataSnapshot.getValue(Map.class);
                        String getkey= map.get("keyword");
                        String getnumber= map.get("Number");
                        String getcontact= map.get("ContactList");
                        String getregion= map.get("IP");
                        String getip= map.get("Region");
                        Log.v("E_VALUE","key :"+getkey);
                        Log.v("E_VALUE","number: "+getnumber);
                        Log.v("E_VALUE","contact: "+getcontact);
                        Log.v("E_VALUE","region: "+getregion);
                        Log.v("E_VALUE","ip: "+getip);
                        tv1.setText(getip.toString());
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }
        });

    }
}
