package com.example.bahung.imageviewzoom;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.bahung.imageviewzoom.Adapter.ImageData;
import com.example.bahung.imageviewzoom.Adapter.Reforit.APIUltils;
import com.example.bahung.imageviewzoom.Adapter.Reforit.DataClient;
import com.example.bahung.imageviewzoom.Model.ImageTask;
import com.example.bahung.imageviewzoom.View.Fragment.GridFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Grid to pager app's main activity.
 */
public class MainActivity extends AppCompatActivity {


    public static int currentPosition;
    private static final String KEY_CURRENT_POSITION = "com.google.samples.gridtopager.key.currentPosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataImage();

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, 0);
            // Return here to prevent adding additional GridFragments when changing orientation.
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, new GridFragment(), GridFragment.class.getSimpleName())
                .commit();
    }

    private void getDataImage()
    {
        DataClient dataClient = APIUltils.getData();
        Call<ImageTask> call = dataClient.getImageOfTask("$2a$08$VD52WxpSWPhq.8CzvIfoaePQwvPveHxpYRfNEDjMWhdJ9O2KZZ2HS", 30, 389);
        call.enqueue(new Callback<ImageTask>() {
            @Override
            public void onResponse(Call<ImageTask> call, Response<ImageTask> response) {
                if(response.isSuccessful()){
                    if(!response.body().isState()){
                        ArrayList<String> dataImage = new ArrayList<>();
                        for(int i=0; i< response.body().getData().size(); i++){
                            dataImage.add(response.body().getData().get(i).getUrl());
                        }
                        ImageData.datas = dataImage;
                        for(int i=0; i<ImageData.datas.size(); i++){
                            Log.d("success", ImageData.datas.get(i));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ImageTask> call, Throwable t) {
                Log.d("error", this.getClass()+" : "+ t.getMessage());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_POSITION, currentPosition);
    }
}