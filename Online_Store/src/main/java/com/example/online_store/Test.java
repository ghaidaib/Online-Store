package com.example.online_store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class Test {

    @GetMapping
    public int get(@RequestParam(name = "x") int x){
        return x+1;
    }
}
