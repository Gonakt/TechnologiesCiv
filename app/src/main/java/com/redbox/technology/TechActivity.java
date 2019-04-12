package com.redbox.technology;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.redbox.technology.fragments.ListFragment;


public class TechActivity extends AppCompatActivity {

    private static String response_from_network = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        Log.d("T", "onCreate: " + "IN ACTIVITY");

        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle extras = getIntent().getExtras();
        response_from_network = extras.getString("J");

        if(fragmentManager.findFragmentByTag("lister") == null){
            ListFragment listFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.infoFragment, listFragment, "lister").addToBackStack(null).commit();
        }

        try {
            Log.d("List ACT GOT RESPONSE ", response_from_network.length() + " ");
        } catch (NullPointerException exc){
            exc.printStackTrace();
        }


    }

    public static String returnResponse() {
        return response_from_network;
    }

}
