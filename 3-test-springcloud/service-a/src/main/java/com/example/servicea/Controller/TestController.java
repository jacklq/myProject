package com.example.servicea.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value( "${server.port}")
    private  String port;

    /**在接口上开启Hystrix服务保护*/
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hello")
    public String hello() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "hello world"+port;
    }
   public String fallback(){
        return  "服务器繁忙";
    }
}