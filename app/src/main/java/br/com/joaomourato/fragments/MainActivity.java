package br.com.joaomourato.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null){ fragmentTransaction.add(R.id.dynamic_fragment_container, new DynamicFragmentList());}
        else{
            fragmentTransaction.replace(R.id.dynamic_fragment_container, new DynamicFragmentList());
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}