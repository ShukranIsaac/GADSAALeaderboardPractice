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
    private String firstName;
    private String lastName;
    private String personalFone;
    private String businessName;
    private String locationOfBusiness;
    private String businessEmail;
    private String businessPhone;
    private String govermentStat;
    private String additionalInfor;

    @Ignore
    protected LeaderPayloadAttr(Parcel in) {
        id = in.readInt();
        uid = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        personalFone = in.readString();
        businessName = in.readString();
        locationOfBusiness = in.readString();
        businessEmail = in.readString();
        businessPhone = in.readString();
        govermentStat = in.readString();
        additionalInfor = in.readString();
    }

    @Ignore
    public LeaderPayloadAttr(Builder builder) {
        this.uid = builder.uid;
        this.additionalInfor = builder.additionalInfor;
        this.businessEmail = builder.businessEmail;
        this.businessName = builder.businessName;
        this.businessPhone = builder.businessPhone;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.govermentStat = builder.govermentStat;
        this.personalFone = builder.personalFone;
        this.locationOfBusiness = builder.locationOfBusiness;
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

    public String additionalInfor() {
        return additionalInfor;
    }

    public String businessEmail() {
        return businessEmail;
    }

    public String personalFone() {
        return personalFone;
    }

    public String govermentStat() {
        return govermentStat;
    }

    public String businessPhone() {
        return businessPhone;
    }

    public String businessName() {
        return businessName;
    }

    public String locationOfBusiness() {
        return locationOfBusiness;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends BaseIdentifiableObject.Builder<LeaderPayloadAttr.Builder> {
        private String uid;
        private String firstName;
        private String lastName;
        private String personalFone;
        private String businessName;
        private String locationOfBusiness;
        private String businessEmail;
        private String businessPhone;
        private String govermentStat;
        private String additionalInfor;

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

        public Builder personalFone(String personalFone) {
            this.personalFone = personalFone;
            return this;
        }

        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder locationOfBusiness(String locationOfBusiness) {
            this.locationOfBusiness = locationOfBusiness;
            return this;
        }

        public Builder businessEmail(String businessEmail) {
            this.businessEmail = businessEmail;
            return this;
        }

        public Builder businessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
            return this;
        }

        public Builder govermentStat(String govermentStat) {
            this.govermentStat = govermentStat;
            return this;
        }

        public Builder additionalInfor(String additionalInfor) {
            this.additionalInfor = additionalInfor;
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
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(personalFone);
        dest.writeString(businessName);
        dest.writeString(locationOfBusiness);
        dest.writeString(businessEmail);
        dest.writeString(businessPhone);
        dest.writeString(govermentStat);
        dest.writeString(additionalInfor);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalFone(String personalFone) {
        this.personalFone = personalFone;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setLocationOfBusiness(String locationOfBusiness) {
        this.locationOfBusiness = locationOfBusiness;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public void setGovermentStat(String govermentStat) {
        this.govermentStat = govermentStat;
    }

    public void setAdditionalInfor(String additionalInfor) {
        this.additionalInfor = additionalInfor;
    }

    @Override
    public String toString() {
        return "LeaderPayloadAttr{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalFone='" + personalFone + '\'' +
                ", businessName='" + businessName + '\'' +
                ", locationOfBusiness='" + locationOfBusiness + '\'' +
                ", businessEmail='" + businessEmail + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", govermentStat='" + govermentStat + '\'' +
                ", additionalInfor='" + additionalInfor + '\'' +
                '}';
    }
}
