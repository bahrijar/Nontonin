package com.example.allseven64.cataloguemovieuiux.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.allseven64.cataloguemovieuiux.R;
import com.example.allseven64.cataloguemovieuiux.SharedPreference;

public class SettingFragment extends Fragment {
    static final String TAG = SettingFragment.class.getSimpleName();
    Context context;
    private Switch mySwitch;
    SharedPreference sharedPreference;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        context = view.getContext();
        mySwitch = view.findViewById(R.id.mySwitch);
        sharedPreference = new SharedPreference(getActivity());

        if (sharedPreference.loadDarkModeState()==true) {
            getActivity().setTheme(R.style.DarkTheme);
        }
        else  getActivity().setTheme(R.style.AppTheme);


        if (sharedPreference.loadDarkModeState()==true) {
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    sharedPreference.setDarkModeState(true);
                    getActivity().recreate();
                }
                else{
                    sharedPreference.setDarkModeState(false);
                   getActivity().recreate();
                }
            }
        });

        return view;
    }


}
