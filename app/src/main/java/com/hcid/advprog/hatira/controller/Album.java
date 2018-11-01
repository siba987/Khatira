package com.hcid.advprog.hatira.controller;

import com.hcid.advprog.hatira.model.AlbumModel;

import java.util.ArrayList;
import java.util.Date;

public abstract class Album {
    private AlbumModel albumModel;

    // Create list of listeners for any changes
    private OnChangeListener listener;

    public OnChangeListener getListener() {
        return listener;
    }

    public void setListener(OnChangeListener listener) {
        this.listener = listener;
    }

    public interface OnChangeListener {
        void onChange();
    }


}
