package com.example.mybarber.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mybarber.Login;
import com.example.mybarber.MainActivity;
import com.example.mybarber.R;
import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    FirebaseAuth mAuth;
    Button signOutBtn;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mAuth = FirebaseAuth.getInstance();
        signOutBtn = getActivity().findViewById(R.id.signout);

        return view;
    }
}