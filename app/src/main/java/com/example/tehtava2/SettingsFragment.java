package com.example.tehtava2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private Switch setWriteable;
    private SharedViewModel model;
    private Data data;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        data = Data.getInstance();
        model = SharedViewModel.getInstance();
        setWriteable = root.findViewById(R.id.writeableSwitch);
        setWriteable.setChecked(data.isEditable());

        if (data.isEditable()) {
            setWriteable.setText("On");
        }

        setWriteable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setWriteable.setText("On");
                } else {
                    setWriteable.setText("Off");
                }
                model.setState(isChecked);
                data.setEditable(isChecked);
            }
        });
        return root;
    }


}