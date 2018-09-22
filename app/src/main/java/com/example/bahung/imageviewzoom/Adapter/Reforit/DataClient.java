package com.example.bahung.imageviewzoom.Adapter.Reforit;

import com.example.bahung.imageviewzoom.Model.ImageTask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface DataClient  {

    @GET("api/get-image-of-task/{TASK_ID}")
    Call<ImageTask> getImageOfTask(@Header("token_user_login") String token, @Header("user_login") int userID, @Path("TASK_ID") int taskID);
}
