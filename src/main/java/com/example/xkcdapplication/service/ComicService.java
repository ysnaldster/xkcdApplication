package com.example.xkcdapplication.service;

import com.example.xkcdapplication.models.ComicModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComicService {
    RestTemplate restTemplate = new RestTemplate();

    public Integer getNum() {
        String url = "https://xkcd.com/info.0.json";
        ComicModel comicModel = (restTemplate.getForObject(url, ComicModel.class));
        return comicModel.getNum();
    }
}
