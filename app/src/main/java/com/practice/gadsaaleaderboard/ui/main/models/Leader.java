package com.practice.gadsaaleaderboard.ui.main.models;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.practice.gadsaaleaderboard.common.models.BaseIdentifiableObject;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Leader.Builder.class)
@JsonSerialize(as = Leader.Builder.class)
@Entity(tableName = "leaders")
public class Leader extends BaseIdentifiableObject {
    @JsonProperty("id")
    @PrimaryKey(autoGenerate = true)
    private @JsonIgnore int id;
    private String uid;
    private String name;
    private String hours;
    private String country;
    private String score;
    private String badgeUrl;

    public Leader() { }

    @Ignore
    protected Leader(Parcel in) {
        id = in.readInt();
        name = in.readString();
        uid = in.readString();
        hours = in.readString();
        country = in.readString();
        score = in.readString();
        badgeUrl = in.readString();
    }

    @Ignore
    protected Leader(Builder builder) {
        this.uid = builder.uid;
        this.name = builder.name;
        this.hours = builder.hours;
        this.country = builder.country;
        this.score = builder.score;
        this.badgeUrl = builder.badgeUrl;
    }

    public static Builder builder() {
        return new Leader.Builder();
    }

    public int getId() {
        return id;
    }

    @Nullable
    @Override
    public String uid() {
        return uid;
    }

    public String name() {
        return name;
    }

    public String hours() {
        return hours;
    }

    public String country() {
        return country;
    }

    public String score() {
        return score;
    }

    public String badgeUrl() {
        return badgeUrl;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends BaseIdentifiableObject.Builder<Builder> {
        private String uid;
        private String name;
        private String hours;
        private String country;
        private String score;
        private String badgeUrl;

        @Override
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder hours(String hours) {
            this.hours = hours;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder score(String score) {
            this.score = score;
            return this;
        }

        public Builder badgeUrl(String badgeUrl) {
            this.badgeUrl = badgeUrl;
            return this;
        }

        public Leader build() {
            return new Leader(this);
        }
    }

    public static final Creator<Leader> CREATOR = new Creator<Leader>() {
        @Override
        public Leader createFromParcel(Parcel in) {
            return new Leader(in);
        }

        @Override
        public Leader[] newArray(int size) {
            return new Leader[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(uid);
        dest.writeString(name);
        dest.writeString(hours);
        dest.writeString(country);
        dest.writeString(score);
        dest.writeString(badgeUrl);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @NotNull
    @Override
    public String toString() {
        return "Leader{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                ", country='" + country + '\'' +
                ", score='" + score + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
