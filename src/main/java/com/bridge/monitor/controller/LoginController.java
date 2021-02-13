package com.bridge.monitor.controller;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.repo.UserRepo;
import com.bridge.monitor.util.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户登录")
@RestController
@Slf4j
public class LoginController {
    @Resource
    private UserRepo userRepo;
    @GetMapping(value = "/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public HttpResponse<UserPo> login(HttpServletRequest request,
                                      @RequestParam("name") String name,
                                      @RequestParam("password") String password) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"账号密码不能为空");
        }
        UserPo user=userRepo.findByName(name);
        if (null==user){
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"用户不存在");
        }
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setTimeout(-1000L);//永不过期
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        try {
            subject.login(usernamePasswordToken);
        } catch (Exception e) {
            log.error("登录失败",e.getMessage());
            return HttpResponse.FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(),"密码不正确");
        }
        return HttpResponse.SUCCESS(user,"登录成功");
    }

    @GetMapping(value = "/logout")
    @ApiOperation(value = "退出登录", notes = "退出登录")
    public HttpResponse<String> logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return HttpResponse.SUCCESS("退出登录成功");
    }

    @GetMapping(value = "/toLogin")
    @ApiOperation(value = "登录提示", notes = "登录提示")
    public HttpResponse<String> toLogin(HttpServletRequest request){
        return HttpResponse.FAIL(HttpStatus.UNAUTHORIZED.value(),"未登录无法访问");
    }
}
