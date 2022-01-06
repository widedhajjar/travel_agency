package fr.lernejo.travelsite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PredictionEngineClient {
    @GET("api/temperature")
    Call<Temperature> listTemperature(@Path("country") String country);
}
