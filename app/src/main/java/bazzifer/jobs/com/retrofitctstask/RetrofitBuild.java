package bazzifer.jobs.com.retrofitctstask;

import android.arch.lifecycle.ViewModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuild extends ViewModel {
    Retrofit retrofit;

    public Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
