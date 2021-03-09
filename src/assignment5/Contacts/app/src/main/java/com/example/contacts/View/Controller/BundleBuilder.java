package com.example.contacts.view.controller;

import android.os.Bundle;
import android.os.Parcelable;

public class BundleBuilder {
    private final Bundle bundle;

    public BundleBuilder(Bundle bundle) {
        this.bundle = bundle;
    }

    public BundleBuilder putParcelable(String key, Parcelable value) {
        bundle.putParcelable(key, value);
        return this;
    }
    public BundleBuilder putInt(String key, int value) {
        bundle.putInt(key, value);
        return this;
    }
    public Bundle build() {
        return bundle;
    }
}
