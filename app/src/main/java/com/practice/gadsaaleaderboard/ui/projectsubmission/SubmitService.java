package com.practice.gadsaaleaderboard.ui.projectsubmission;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Project Submit Completion Details: Google Forms API
 *
 * @author Isaac S. Mwakabira(imwakabira@cc.ac.mw)
 */
public interface SubmitService {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Observable<ResponseBody> merchantRest(
            @Field("entry.1659819444") String firstName,
            @Field("entry.472564179") String lastName,
            @Field("entry.285899941") String personalFone,
            @Field("entry.699265956") String businessName,
            @Field("entry.922324374") String locationOfBusiness,
            @Field("entry.163074460") String businessEmail,
            @Field("entry.729953638") String businessPhone,
            @Field("entry.352488134") String govermentStat,
            @Field("entry.1293650130") String additionalInfor
    );
}
