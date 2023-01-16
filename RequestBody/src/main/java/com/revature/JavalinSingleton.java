package com.revature;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;

/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        
        /**
         * problem1: retrieve the song object from the request body and return the artist name.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance if needed.
         */
        app.post("/problem1", ctx -> {
                
        String jsonString = ctx.body();

    ObjectMapper om = new ObjectMapper();
    Song p1 = om.readValue(jsonString, Song.class);

    ctx.result(p1.getArtistName());


        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance if needed.
         */
        app.post("/problem2", ctx -> {
           
            String jsonString = ctx.body();

            ObjectMapper om = new ObjectMapper();
            Song p2 = om.readValue(jsonString, Song.class);

            //we need to let the request know we will send back json in the body
            ctx.contentType("application/json"); 

            p2.setArtistName("Beatles");
    
            //utilize jackson convert back the user object to a json string
            String jsonStringToBeReturned = om.writeValueAsString(p2);

            //return the json string in the response body
            ctx.result(jsonStringToBeReturned);
        });


        return app;
    }
    
}
