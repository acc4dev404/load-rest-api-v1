package com.example.load_rest_api_v1.controller;

import com.example.load_rest_api_v1.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import jakarta.validation.Valid;

/**
 * @author Valeev A.R.
 */

@RestController
public class MainController {

    private long setOffsetTime(int minOffsetTime, int maxOffsetTime) throws InterruptedException {
        long start = System.currentTimeMillis();
        int randomTime = (int) ((Math.random() * (maxOffsetTime - minOffsetTime)) + minOffsetTime);
        Thread.sleep(randomTime);
        return System.currentTimeMillis() - start;
    }

    @GetMapping(path="/")
    @ResponseBody
    public ResponseEntity getUser() throws InterruptedException {
        long offsetTime = setOffsetTime(1000,2000);
        /* Set header:
         MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
         map.add("Set-Cookie","jmeter=true"); - cookie
         map.add("jmeter","true"); - header
         new ResponseEntity(data, header, status); }
        */
        return new ResponseEntity(new User("static","Static"), HttpStatus.OK);
    }

    @PostMapping(path="/class")
    @ResponseBody
    public ResponseEntity<?> postUser(@RequestBody @Valid User user) throws InterruptedException {
        long offsetTime = setOffsetTime(1000,2000);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path="/map")
    @ResponseBody
    public ResponseEntity<?> postUsers(@RequestBody Map<String, String> body) throws InterruptedException {
        long offsetTime = setOffsetTime(1000,2000);
        String login = body.get("login") == null ? null: body.get("login").toString();
        String password = body.get("password") == null ? null: body.get("password").toString();
        if (login != null && password != null && body.size() == 2)
            if (!login.trim().isEmpty() && !password.trim().isEmpty())
                return new ResponseEntity<>(new User(login, password), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}