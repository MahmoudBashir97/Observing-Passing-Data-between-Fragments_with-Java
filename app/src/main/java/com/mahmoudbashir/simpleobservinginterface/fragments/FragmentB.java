package com.mahmoudbashir.simpleobservinginterface.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mahmoudbashir.simpleobservinginterface.R;


public class FragmentB extends Fragment {

    private EditText editText;
    private Button buttonOk;
    private FragmentBListener fragmentBListener;


   public interface FragmentBListener{
        void onInputEntered(CharSequence input);
    }
    public FragmentB(){}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentB.FragmentBListener) {
            fragmentBListener = (FragmentB.FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_b, container, false);

        editText = v.findViewById(R.id.edit_text);
        buttonOk = v.findViewById(R.id.button_ok);


        buttonOk.setOnClickListener(v1 -> {
            CharSequence input = editText.getText();
            fragmentBListener.onInputEntered(input);
        });


        return v;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onDetach() {
        fragmentBListener = null;
        super.onDetach();
    }
}