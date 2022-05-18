package apiTests;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationDeserialization {

    static {
        baseURI = "http://localhost:8080/app";
    }


    @Test
    public void testSerializedUsingMap(){

        int id = 20 + new Random().nextInt(1000);


        Map<String,Object> videoGameMap = new HashMap<>();
            videoGameMap.put("id", id);
            videoGameMap.put("name", "Tetris");
            videoGameMap.put("releaseDate", "1984-06-25");
            videoGameMap.put("reviewScore", 88);
            videoGameMap.put("category", "Puzzle");
            videoGameMap.put("rating", "Universal");


        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGameMap).
                //serialization is done automatically by built in libraries like Jackson, Gson, etc.
                when().log().all().
                post("/videogames").
                then().log().all().
                assertThat().
                statusCode(equalTo(200)).
//                header("Content-Type", equalTo("application/json")).
                body("status", is("Record Added Successfully"));

    }
    @Test
    public void testSerializedUsingPOJO(){

        int id = 20 + new Random().nextInt(1000);


        VideoGame videoGame = new VideoGame(
                id,
                "Half-Life",
                "1999-01-01",
                98,
                "FPS",
                "PG13");


        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGame).
                //serialization is done automatically by built in libraries like Jackson, Gson, etc.
                        when().log().all().
                post("/videogames").
                then().log().all().
                assertThat().
                statusCode(equalTo(200)).
//                header("Content-Type", equalTo("application/json")).
        body("status", is("Record Added Successfully"));

    }
    @Test
    public void deserializationUsingMap(){

        VideoGame videoGame = new VideoGame(
                3,
                "Half-Life",
                "1999-01-01",
                98,
                "FPS",
                "PG13");

        Map map = given().
                header("Accept", "application/json").       // I can accept/understand only json
                header("Content-Type", "application/json").
                body(videoGame).
                pathParam("videoGameId", "2").
                when().log().all().
                put("/videogames/{videoGameId}").
                then().log().all().
                statusCode(is(200)).
                body("id", equalTo(2)).
                header("Content-Type", "application/json").extract().as(Map.class);

        System.out.println(map);

        System.out.println(map.get("name"));

    }
    @Test
    public void deserializationUsingPOJO(){

        VideoGame videoGame = new VideoGame(
                3,
                "Half-Life",
                "1999-01-01",
                98,
                "FPS",
                "PG13");

        VideoGame responseAsVideoGameObject = given().
                header("Accept", "application/json").       // I can accept/understand only json
                        header("Content-Type", "application/json").
                body(videoGame).
                pathParam("videoGameId", "5").
                when().log().all().
                put("/videogames/{videoGameId}").
                then().log().all().
                statusCode(is(200)).
                body("id", equalTo(2)).
                header("Content-Type", "application/json").extract().as(VideoGame.class);

        System.out.println(responseAsVideoGameObject);

        System.out.println(responseAsVideoGameObject.getName());


    }



}
