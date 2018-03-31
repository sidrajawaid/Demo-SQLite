package com.dragonzmart.demofirebaseapp;

import android.app.Activity;
import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Sidra on 11/30/2017.
 */

public class DemoFirebaseApp2 extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
