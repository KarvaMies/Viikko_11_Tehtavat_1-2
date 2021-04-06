package com.example.tehtava2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Boolean> state = new MutableLiveData<Boolean>();
    private final MutableLiveData<CharSequence> text = new MutableLiveData<CharSequence>();

    static SharedViewModel singleton = new SharedViewModel();

    private SharedViewModel() {}

    public static SharedViewModel getInstance() {
        return singleton;
    }

    public void setState(Boolean state) {
        this.state.setValue(state);
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public LiveData<Boolean> getState() {
        return state;
    }

    public LiveData<CharSequence> getText() {
        if (text.getValue() == null) {
            text.setValue("");
        }
        return text;
    }
}
