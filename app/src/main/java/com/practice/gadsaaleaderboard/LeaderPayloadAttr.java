package com.practice.gadsaaleaderboard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Isaac S. Mwakabira(imwakabira@cc.ac.mw)
 */
public class LeaderPayloadAttr implements Parcelable {
    private String firstName;
    private String lastName;
    private String personalFone;
    private String businessName;
    private String locationOfBusiness;
    private String businessEmail;
    private String businessPhone;
    private String govermentStat;
    private String additionalInfor;

    protected LeaderPayloadAttr(Parcel in) {
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
}
