package bazzifer.jobs.com.retrofitctstask;

import java.util.List;

import bazzifer.jobs.com.retrofitctstask.Model.APIResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    String baseurl = "http://navjacinth9.000webhostapp.com/json/";
    @GET("retrofit-demo.php?company_no=123")
    Call<APIResponse> getresult();
}
