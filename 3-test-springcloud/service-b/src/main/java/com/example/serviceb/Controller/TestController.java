package com.example.serviceb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Autowired
    private ServiceAFeignClient serverAFeignClient;

    @RequestMapping("/call")
    public String call() {
        String result = serverAFeignClient.hello();
        return "b to a 访问结果 ----- " + result;
    }
}