package cn.weli.learnandroiddemo.fram;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Grekit
 * @description
 * @date
 */
public interface WeatherService {

    @GET("WEATHER_MINI")
    String getMessage(@Query("city")String city);
}
