package com.hcid.advprog.hatira.model;

import com.hcid.advprog.hatira.controller.Album;

import java.util.ArrayList;
import java.util.List;

public class PhotoModel {

    private List<Album.OnChangeListener> changeListeners = new ArrayList<>();
   /* public void fireChangeListeners() {
        for (ChangeListener l : changeListeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }
*/

}
