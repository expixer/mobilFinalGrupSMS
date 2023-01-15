package com.example.grupsms.ui.logout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.grupsms.R;
import com.google.firebase.auth.FirebaseAuth;


public class LogoutFragment extends Fragment {
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Toast.makeText(getActivity(), "Başarıyla çıkış yapıldı.", Toast.LENGTH_SHORT).show();
        getActivity().finish();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }
}