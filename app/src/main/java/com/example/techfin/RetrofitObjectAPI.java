package com.example.techfin;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitObjectAPI {
    @GET("424571?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectData();
    @GET("424500?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectDataType1();
    @GET("424800?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectDataType2();
    @GET("424900?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectDataType3();
    @GET("424307?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectDataType4();
    @GET("424450?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<model> getJsonObjectDataType5();


}
