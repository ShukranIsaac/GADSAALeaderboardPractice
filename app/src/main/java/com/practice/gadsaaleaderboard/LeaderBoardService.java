package com.practice.gadsaaleaderboard;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * GADS AAD Leaderboard: GADS Heroku API
 *
 * @author Isaac S. Mwakabira(imwakabira@cc.ac.mw)
 */
public interface LeaderBoardService {
    @GET("hours")
    Observable<ArrayList<Leader>> leaderBoardHours();

    @GET("skilliq")
    Observable<ArrayList<Leader>> leaderBoardSkillIQs();
}
