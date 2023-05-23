package com.triviabuild.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.triviabuild.trivia.Trivia;
import com.triviabuild.util.PropertiesLoader;
import lombok.extern.java.Log;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Trivia dao.
 */
@Log
public class triviaDAO implements PropertiesLoader {
    Properties properties;
    public static String API_URL;

    /**
     * Load properties for correct URI for the API
     */
    private void loadProperties() {
        try {
            properties = loadProperties("/trivia.properties");
            API_URL = properties.getProperty("opentdb");
        } catch (IOException ioE) {
            log.severe("cannot load properties..." + ioE);
        } catch (Exception e) {
            log.severe("Error loading properties... " + e);
        }
    }

    /**
     * Writes the correct URI for getting the API based on the params
     * @param amount -- num of questions pulled (max 50)
     * @param category -- category of questions
     * @param difficulty -- easy, medium, or hard
     * @param type -- multiple or boolean (T/F)
     * @return
     */
    private String url_key (int amount, int category, String difficulty, String type) {
        loadProperties();
        String result = properties.getProperty("opentdb") +
                "?amount=" + amount +
                "&category=" + category +
                "&difficulty=" + difficulty +
                "&type=" + type;
//        log.info("    **** url_key -- " + result);
        return result;
    }

    /**
     * Configures the API endpoint call for the specific params
     * @param amount -- num of questions
     * @param category -- category/topic of questions
     * @param difficulty -- difficulty of questions
     * @return -- string with the correct API endpoint
     */
    private String newURL (int amount, int category, String difficulty) {
        loadProperties();
        String result = properties.getProperty("opentdb") +
                "?amount=" + amount +
                "&category=" + category +
                "&difficulty=" + difficulty;
//            log.info("    **** newURL key:  " + result);
            return result;
    }

    /**
     * Randomly selects a single question from the API
     * @return  a response from the GET methods for the Trivia API
     * @param amount -- number of questions pulled (max 50);
     * @param category -- which category of question
     * @param difficulty -- easy, medium, or hard
     */
    public Trivia randomQuestion(int amount, int category, String difficulty) {
        Client client = ClientBuilder.newClient();
        String uri = url_key(amount, category, difficulty, "multiple" );
        WebTarget target =
                client.target(uri);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Trivia currentResponse = new Trivia();
        try {
            currentResponse = mapper.readValue(response, Trivia.class);
        } catch (JsonProcessingException e) {
            log.severe("Error processing JSON... " + e);
        }
        return currentResponse;
    }


    /**
     * Gets eight questions from the API.
     * @param category   the category
     * @param difficulty the difficulty
     * @return a trivia object with the current API call response
     */
    public Trivia getEightQuestions(int category, String difficulty) {
        Client client = ClientBuilder.newClient();
        String uri = newURL(8, category, difficulty);
        WebTarget target =
                client.target(uri);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Trivia currentResponse = new Trivia();
        try {
            currentResponse = mapper.readValue(response, Trivia.class);
        } catch (JsonProcessingException e) {
            log.severe("Error processing JSON... " + e);
        }
        return currentResponse;
    }


    /**
     * For testing purposes -- JSON hard-coded
     * @return  returns a Trivia Object response to the API call (hard-coded API)
     */
    public Trivia hardCoded() {
        String response = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Music\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"The Rush song &quot;YYZ&quot; derives its name from the IATA aiport identification code for which city?\",\"correct_answer\":\"Toronto\",\"incorrect_answers\":[\"Vancouver\",\"Ottawa\",\"Calgary\"]}]}";
//        log.info("   ***Hard-coded-Response(JSON): " + response);
        ObjectMapper mapper = new ObjectMapper();
        Trivia currentResponse = new Trivia();
        try {
            currentResponse = mapper.readValue(response, Trivia.class);
        } catch (JsonProcessingException e) {
            log.severe("Error processing JSON... " + e);
        }
        return currentResponse;
    }


    /**
     * very UGLY way to hardcode and test for multiple questions
     * @return  Trivia object response to API call (hard-coded)
     */
    public Trivia multipleTEST() {
        String response = "{\n" +
                "   \"response_code\": 0,\n" +
                "   \"results\":    [\n" +
                "            {\n" +
                "         \"category\": \"Entertainment: Music\",\n" +
                "         \"type\": \"multiple\",\n" +
                "         \"difficulty\": \"easy\",\n" +
                "         \"question\": \"&quot;Some people call me the space cowboy&quot; is the first line from what song?\",\n" +
                "         \"correct_answer\": \"The Joker\",\n" +
                "         \"incorrect_answers\":          [\n" +
                "            \"Fandango\",\n" +
                "            \"Take The Money and Run\",\n" +
                "            \"Fly Like an Eagle\"\n" +
                "         ]\n" +
                "      },\n" +
                "            {\n" +
                "         \"category\": \"Entertainment: Music\",\n" +
                "         \"type\": \"multiple\",\n" +
                "         \"difficulty\": \"easy\",\n" +
                "         \"question\": \"The Red Hot Chili Pepper song &quot;Give It Away&quot; is from what album?\",\n" +
                "         \"correct_answer\": \"Blood Sugar Sex Magik\",\n" +
                "         \"incorrect_answers\":          [\n" +
                "            \"One Hot Minute\",\n" +
                "            \"By the Way\",\n" +
                "            \"Stadium Arcadium\"\n" +
                "         ]\n" +
                "      },\n" +
                "            {\n" +
                "         \"category\": \"Entertainment: Music\",\n" +
                "         \"type\": \"boolean\",\n" +
                "         \"difficulty\": \"easy\",\n" +
                "         \"question\": \"Eurobeat is primarily an Italian genre of music.\",\n" +
                "         \"correct_answer\": \"True\",\n" +
                "         \"incorrect_answers\": [\"False\"]\n" +
                "      },\n" +
                "            {\n" +
                "         \"category\": \"Entertainment: Music\",\n" +
                "         \"type\": \"multiple\",\n" +
                "         \"difficulty\": \"easy\",\n" +
                "         \"question\": \"Brian May was the guitarist for which band?\",\n" +
                "         \"correct_answer\": \"Queen\",\n" +
                "         \"incorrect_answers\":          [\n" +
                "            \"Pink Floyd\",\n" +
                "            \"Rolling Stones\",\n" +
                "            \"The Doors\"\n" +
                "         ]\n" +
                "      },\n" +
                "            {\n" +
                "         \"category\": \"Entertainment: Music\",\n" +
                "         \"type\": \"multiple\",\n" +
                "         \"difficulty\": \"easy\",\n" +
                "         \"question\": \"The band Muse released their first album, Showbiz, in what year?\",\n" +
                "         \"correct_answer\": \"1999\",\n" +
                "         \"incorrect_answers\":          [\n" +
                "            \"1998\",\n" +
                "            \"2000\",\n" +
                "            \"2001\"\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Trivia currentResponse = new Trivia();
        try {
            currentResponse = mapper.readValue(response, Trivia.class);
        } catch (JsonProcessingException e) {
            log.severe("Error processing JSON... " + e);
        }
        return currentResponse;
    }

}
