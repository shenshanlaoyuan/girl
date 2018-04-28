package com.shenshanlaoyuan.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by shenshanlaoyuan on 2018/4/22.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id:" + id;
    }
}
