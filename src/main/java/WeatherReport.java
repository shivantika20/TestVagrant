package main.java;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WeatherReport {

    public static void main(String[] args)
    {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String response = given().queryParam("q","bengaluru").
                queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").
                when().get("data/2.5/weather").then().assertThat().statusCode(200).extract().response().asString();
      //Inorder to print the whole response we can uncomment the below line
        //System.out.println(response);
        JsonPath js = new JsonPath(response);
        String name = js.getString("name");
        String temperature = js.getString("main.temp");
        String description = js.getString("weather[0].description");
        String humidity = js.getString("main.humidity");
        String wind_speed = js.getString("wind.speed");
        String wind_deg = js.getString("wind.deg");
        System.out.println("City name is : " + name);
        System.out.println("Current Temperature is : " + temperature);
        System.out.println("Weather is : " + description);
        System.out.println("Humidity is : " + humidity);
        System.out.println("Wind Speed is : " + wind_speed);
        System.out.println("Wind Degree is : " + wind_deg);
    }
}
