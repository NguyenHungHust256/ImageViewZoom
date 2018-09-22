package com.example.bahung.imageviewzoom.Adapter.Reforit;

public class APIUltils {
    public static DataClient getData() {
        return RetrofitClient.getClient("http://103.216.112.194:4000/").create(DataClient.class);
    }
}
