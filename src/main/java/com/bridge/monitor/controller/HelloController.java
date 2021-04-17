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
import java.io.UnsupportedEncodingException;

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

    @GetMapping(value = "/testCN")
    @ApiOperation(value = "测试中文字符", notes = "测试中文字符")
    public HttpResponse<String> testCN(String name){
        System.out.println(name);
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String aa="x86服务器";
        String str = new String(aa.getBytes("utf-8"),"iso8859-1");
        System.out.println(str);
    }
}
