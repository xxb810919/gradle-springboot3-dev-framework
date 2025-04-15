package com.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    public static void main(String[] args) {

    }

    @RequestMapping("/tt")
    public Map test() {
        Map map = new HashMap();
        map.put("code", 0);
        return map;
    }

}
