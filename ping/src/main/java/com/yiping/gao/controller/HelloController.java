package com.yiping.gao.controller;

import com.yiping.gao.pojo.dto.Bank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "Hello Spring Boot!";
    }

    @Value("${name}")
    public String name;

    @Value("${user}")
    public String user;

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String name() {
        return name;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return user;
    }

    /**
     * 适用于下面的取值
     * http://localhost:8080/spring-boot/100/urlVariable
     */
    @RequestMapping(value = "/${id}/urlVariable", method = RequestMethod.GET)
    public String urlVariable(@PathVariable("id")Integer id){
        return "id:" + id;
    }

    /**
     * 适用于下面的取值
     * http://localhost:8080/spring-boot/urlParam?id=100
     */
    @RequestMapping(value = "/urlParam", method = RequestMethod.GET)
    public String urlParam(@RequestParam("id")Integer id){
        return "id:" + id;
    }

    /**
     * 适用于下面的取值
     * http://localhost:8080/spring-boot/urlParam?id=100
     * 并设定默认值
     */
    @RequestMapping(value = "/requestParam", method = RequestMethod.GET)
    /**
     * @GetMapping(value = "/requestParam") ==> @RequestMapping(value = "/requestParam", method = RequestMethod.GET)
     * @PostMapping(value = "/requestParam") ==> @RequestMapping(value = "/requestParam", method = RequestMethod.POST)
     */
    public String requestParam(@RequestParam(value = "id", required = false, defaultValue = "0")Integer id){
        return "id:" + id;
    }

    @PostMapping(value = "/bank")
    public void bankSave(@Validated Bank bank, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return;
        }
    }
}
