package com.griso.hexagonal.common.adapter.rest.controller.implementation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/test")
public class PublicControllerTest {

    @GetMapping
    public String hail() {
        return "Hola";
    }
}
