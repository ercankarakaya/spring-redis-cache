package com.ercan.api;

import com.ercan.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    int sayac = 0;

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(sayac==5){
            sayac=0;
            return  redisCacheService.clearCache();
        }
        sayac++;
        return redisCacheService.longRunningMethod();
    }

}
