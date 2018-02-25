package info.androidhive.expandablelistview.network;


import java.util.List;

import info.androidhive.expandablelistview.model.Desserts;
import retrofit.Callback;
import retrofit.http.GET;

public interface api {

    @GET("/desserts.json")
    public void getData(Callback<List<Desserts>> response);


}


