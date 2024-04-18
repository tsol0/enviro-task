package com.enviro.assessment.grad001.tsolokhambule.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * DemoController
 */
@RestController
public class DemoController {

    @RequestMapping("/")
    public String Hello() {
        return "Hello Hi";
    }

    @RequestMapping("/world")
    public String  World() {
        return "World!";
    }
    
    
}