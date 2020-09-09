package com.practice.gadsaaleaderboard.ui.projectsubmission;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.practice.gadsaaleaderboard.ui.common.BaseIdentifiableObject;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author Isaac S. Mwakabira(imwakabira@cc.ac.mw)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = LeaderPayloadAttr.Builder.class)
@JsonSerialize(as = LeaderPayloadAttr.Builder.class)
@Entity(tableName = "projects")
public final class LeaderPayloadAttr extends BaseIdentifiableObject {
    @JsonProperty("id")
    @PrimaryKey(autoGenerate = true)
    private @JsonIgnore int id;
    private String uid;
    private String email;
    private String firstName;
    private String lastName;
    private String track;
    private String github_link;
    private String phone;

    @Ignore
    protected LeaderPayloadAttr(Parcel in) {
        id = in.readInt();
        uid = in.readString();
        email = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        track = in.readString();
        github_link = in.readString();
        phone = in.readString();
    }

    @Ignore
    public LeaderPayloadAttr(Builder builder) {
        this.uid = builder.uid;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.track = builder.track;
        this.github_link = builder.github_link;
    }

    public static Builder builder() {
        return new LeaderPayloadAttr.Builder();
    }

    public int getId() {
        return id;
    }

    @Override
    public String uid() {
        return uid;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String track() {
        return track;
    }

    public String phone() {
        return phone;
    }

    public String githubLink() {
        return github_link;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends BaseIdentifiableObject.Builder<LeaderPayloadAttr.Builder> {
        private String uid;
        private String email;
        private String firstName;
        private String lastName;
        private String track;
        private String phone;
        private String github_link;

        @Override
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder track(String track) {
            this.track = track;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder githubLink(String github_link) {
            this.github_link = github_link;
            return this;
        }

        public LeaderPayloadAttr build() {
            return new LeaderPayloadAttr(this);
        }
    }

    public static final Creator<LeaderPayloadAttr> CREATOR = new Creator<LeaderPayloadAttr>() {
        @Override
        public LeaderPayloadAttr createFromParcel(Parcel in) {
            return new LeaderPayloadAttr(in);
        }

        @Override
        public LeaderPayloadAttr[] newArray(int size) {
            return new LeaderPayloadAttr[size];
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
        dest.writeString(email);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(track);
        dest.writeString(github_link);
        dest.writeString(phone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGithubLink(String github_link) {
        this.github_link = github_link;
    }

    @Override
    public String toString() {
        return "LeaderPayloadAttr{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", track='" + track + '\'' +
                ", github_link='" + github_link + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
