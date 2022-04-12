package com.example.xkcdapplication.controller;

import com.example.xkcdapplication.service.ComicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RequestMapping(value = "/comicApiXKCD", produces = "application/json")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class ComicController {
    RestTemplate restTemplate = new RestTemplate();
    private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @GetMapping
    public Object getDataApiXKCD() {
        Integer num = comicService.getNum();
        Random randomNumber = new Random();
        int getNumber = randomNumber.nextInt(num) + 1;
        String url = "https://xkcd.com/" + getNumber + "/info.0.json";
        return restTemplate.getForObject(url, Object.class);
    }
}
