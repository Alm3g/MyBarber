package com.example.mybarber.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mybarber.R;
import com.example.mybarber.intent;
import com.example.mybarber.settings.SettingsFragment;
import com.google.firebase.auth.FirebaseAuth;



public class ProfileFragment extends Fragment implements View.OnClickListener {

    TextView username;
    ImageButton settings;
    private FirebaseAuth mAuth;

    public ProfileFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth = FirebaseAuth.getInstance();

        username = view.findViewById(R.id.username);
        username.setText(mAuth.getCurrentUser().getDisplayName().toString());
        settings = view.findViewById(R.id.settings);
        settings.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
