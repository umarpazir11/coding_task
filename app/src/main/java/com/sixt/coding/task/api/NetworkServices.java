package com.sixt.coding.task.api;

import com.google.gson.JsonObject;
import com.sixt.coding.task.model.Car;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;

public interface NetworkServices {

    @GET("cars")
    Observable<List<Car>> getCars();
}
