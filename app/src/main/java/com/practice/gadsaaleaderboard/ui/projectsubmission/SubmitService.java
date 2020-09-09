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
    Observable<ResponseBody> submitProject(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String first_name,
            @Field("entry.2006916086") String last_name,
            @Field("entry.284483984") String github_link
    );

}
