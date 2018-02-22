package ru.antonc.fiftyshots.di.module;

import android.os.Build;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.antonc.fiftyshots.data.rest.ShotsService;
import ru.antonc.fiftyshots.data.rest.Tls12SocketFactory;

import static ru.antonc.fiftyshots.app.Constants.DRIBBBLE_CLIENT_ACCESS_TOKEN;
import static ru.antonc.fiftyshots.app.Urls.DRIBBBLE_URL;

/**
 * Created by antonc on 22.02.2018.
 */

@Module
public class NetModule {


    @Provides
    @Singleton
    ShotsService provideShotService(OkHttpClient.Builder okHttpClientBuilder) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder.addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DRIBBBLE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build();


        return retrofit.create(ShotsService.class);
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            Request authRequest = request.newBuilder().addHeader("Authorization", "Bearer " + DRIBBBLE_CLIENT_ACCESS_TOKEN).build();
            return chain.proceed(authRequest);
        });

        if (Build.VERSION.SDK_INT < 22)
            builder = Tls12SocketFactory.enableTls12OnPreLollipop(builder);

        return builder;
    }

}
