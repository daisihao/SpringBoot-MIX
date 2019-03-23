package com.daisihao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/log")
    public String hello() {
        logger.info("=======输出INFO信息=======");
        return "hello3";
    }
}
/**/