package com.example.load_rest_api_v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Valeev A.R.
 */

@RestController
public class MainController {

    private long setOffsetResponseTime(int min, int max ) throws InterruptedException {
        long start = System.currentTimeMillis();
        int offsetResponseTime = getRandomInt(min, max);
        Thread.sleep(offsetResponseTime);
        return System.currentTimeMillis() - start;
    }
    private int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Map> handleGetUser() throws InterruptedException {
        long offsetResponseTime = setOffsetResponseTime(1000, 2000);

        String login = "Your login";
        String password = "Your password";
        String datetimeConnect = "Datetime connection";

        Map data = new HashMap<>();

        data.put("login", login);
        data.put("password", password);
        data.put("date", datetimeConnect);

        /* Add offset response time */
        //data.put("response time", offsetResponseTime);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        /* Set cookie */
        //map.add("Set-Cookie","jmeter=true");

        return new ResponseEntity<Map>(data, map, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Map> handlePostUser(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws InterruptedException {
        long offsetResponseTime = setOffsetResponseTime(1000, 2000);
        String login = null;
        String password = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(payload.toString());
            login = node.get("login").asText();
            password = node.get("password").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        String datetimeConnect = dateFormat.format(date);

        Map data = new HashMap<>();

        data.put("login", login);
        data.put("password", password);
        data.put("date", datetimeConnect);

        /* Add offset response time */
        //data.put("response time", offsetResponseTime);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        /* Set head */
        //map.add("jmeter", "true");

        return new ResponseEntity<Map>(data, map, HttpStatus.OK);
    }
}