package com.evgeniykim.vpntest.model;

public class Model {

    String mImage;
    String mName;

//    public Model() {}

    public Model(String mImage, String mName) {
        this.mImage = mImage;
        this.mName = mName;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

}
