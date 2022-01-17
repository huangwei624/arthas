package org.onedata.jvmtarget.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @author: huangwei
 * @date: 2022/1/17 22:04
 * @description: HelloController
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "word";
    }

}
