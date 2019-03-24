package bazzifer.jobs.com.retrofitctstask;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import bazzifer.jobs.com.retrofitctstask.Adapter.CustomAdapter;
import bazzifer.jobs.com.retrofitctstask.Model.APIResponse;
import bazzifer.jobs.com.retrofitctstask.Model.EmployeeListItem;
import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    List<EmployeeListItem> employeeListItems;
    MutableLiveData<APIResponse> mutableLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new Lifeobserver());
        mutableLiveData = new MutableLiveData<>();
        ButterKnife.inject(this);
//Retrofit retrofitBuild = new RetrofitBuild().getRetrofit();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            RetrofitBuild retrofitBuild = ViewModelProviders.of(this).get(RetrofitBuild.class);
            Log.e("eeee0", "viewmodelcreate");
            retrofitBuild.getRetrofit();
//RetrofitAPI retrofitAPI = retrofitBuild.create(RetrofitAPI.class);
            RetrofitAPI retrofitAPI = retrofitBuild.retrofit.create(RetrofitAPI.class);
            Call<APIResponse> call = retrofitAPI.getresult();
            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                    getresult(response.body().getEmployeeList());
                    mutableLiveData.setValue(response.body());
                    mutableLiveData.observe(MainActivity.this, new Observer<APIResponse>() {
                        @Override
                        public void onChanged(@Nullable APIResponse apiResponse) {
                            Toast.makeText(MainActivity.this, apiResponse + "No Internet COnnection", Toast.LENGTH_LONG).show();
                            Log.i("livedata", "livedata" + apiResponse);
                        }
                    });

                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_LONG).show();
        }

    }

    private void getresult(List<EmployeeListItem> employeeList) {
        CustomAdapter customAdapter = new CustomAdapter(this, employeeList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

    }


}