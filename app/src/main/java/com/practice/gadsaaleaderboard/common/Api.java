package com.practice.gadsaaleaderboard.common;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import timber.log.Timber;

/**
 * Generic Singleton service class for Api calls
 * using Retrofit, RxJava & RxAndroid
 *
 * @author Isaac S. Mwakabira(imwakabira@cc.ac.mw)
 */
public class Api {
    private static Api INSTANCE;

    private Api() { }

    // singleton
    public static synchronized Api getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Api();
        }
        return INSTANCE;
    }

    public <T> T create(Class<T> clazz) {
        return new Retrofit.Builder()
                .baseUrl(Constant.DEFAULT_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapperFactory.objectMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(provideOkHttpClient(authenticate())).validateEagerly(true)
                .build().create(clazz);
    }

    /**
     * OkHttpClient provider
     */
    private static OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(interceptor)
                .build();
    }

    /**
     * Define interceptor, specifying headers,
     * authentications and authorizations
     */
    private Interceptor authenticate() {
        return chain -> {
            Timber.d("BASE_URL: %s", chain.request().url());
            return chain.proceed(chain.request()
                    .newBuilder()
                    .build());
        };
    }
}
