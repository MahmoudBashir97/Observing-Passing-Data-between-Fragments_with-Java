package com.mahmoudbashir.simpleobservinginterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mahmoudbashir.simpleobservinginterface.fragments.FragmentA;
import com.mahmoudbashir.simpleobservinginterface.fragments.FragmentB;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener,FragmentB.FragmentBListener{

    private FragmentA fA;
    private FragmentB fB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fA = new FragmentA();
        fB = new FragmentB();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_a,fA)
                .replace(R.id.container_b,fB)
                .commit();

    }

    @Override
    public void onInputASent(CharSequence input) {
        fB.updateEditText(input);
    }

    @Override
    public void onInputEntered(CharSequence input) {
        fA.updateEditText(input);
    }
}