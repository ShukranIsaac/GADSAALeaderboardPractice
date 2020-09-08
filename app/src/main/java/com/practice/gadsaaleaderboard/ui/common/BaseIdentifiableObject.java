package com.practice.gadsaaleaderboard.ui.common;

import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import androidx.annotation.Nullable;

public abstract class BaseIdentifiableObject implements IdentifiableObject, Parcelable {
    public static final String UID = "uid";

    @Override
    @JsonProperty(UID)
    @Nullable
    public abstract String uid();

    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder<T extends Builder> {
        @JsonProperty(UID)
        public abstract T uid(String uid);
    }
}
