package com.example.tehtava2;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

public class HomeFragment extends Fragment {

    private Data data;
    private TextView read;
    private EditText write;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        read = root.findViewById(R.id.readOnly);
        write = root.findViewById(R.id.writeOnly);
        data = Data.getInstance();

        if (data.getText() == null) {
        } else if (!data.getText().isEmpty()) {
            write.setText(data.getText());
        }
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (data.getText() != null) {
            write.setText(data.getText());
        }

        if (data.isEditable()) {
            write.setInputType(InputType.TYPE_CLASS_TEXT);

            if ((data.getText() != null) && (!data.getText().isEmpty())) {
                read.setText(data.getText());
            } else if (data.getPreviousText() != null && (!data.getPreviousText().isEmpty())) {
                read.setText(data.getPreviousText());
            }

            write.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if ((data.getText() != null) && (!data.getText().isEmpty())) {
                        data.setPreviousText(data.getText());
                    }
                    data.setText(s.toString());
                }
            });
        } else {
            write.setInputType(InputType.TYPE_NULL);
            if ((data.getText() != null) && (!data.getText().isEmpty())) {
                read.setText(data.getText());
            }
        }
    }
}