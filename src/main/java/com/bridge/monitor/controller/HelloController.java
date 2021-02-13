package com.bridge.monitor.controller;

import com.bridge.monitor.util.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "测试类")
@RestController
@RequestMapping(value = "/hello")
@Slf4j
public class HelloController {

    @GetMapping("")
    @ApiOperation(value = "test", notes = "test")
    public HttpResponse<String>get(
    HttpServletRequest request){
        return HttpResponse.SUCCESS("123");
    }
}
