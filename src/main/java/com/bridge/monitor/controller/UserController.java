package com.bridge.monitor.controller;

import com.bridge.monitor.entity.UserPo;
import com.bridge.monitor.model.UserInVo;
import com.bridge.monitor.service.UserService;
import com.bridge.monitor.util.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @GetMapping(value = "/findUserList")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    public HttpResponse<Page<UserPo>> findUserList(HttpServletRequest request,
                                                   String phone,
                                                    @RequestParam(name = "pageSize",defaultValue = "20") int pageSize,
                                                   @RequestParam(name = "pageNum",defaultValue = "1") int pageNum) {
        return userService.findUserList(phone, pageSize, pageNum);
    }

    @PostMapping(value = "/saveUser")
    @ApiOperation(value = "保存用户", notes = "保存用户")
    public HttpResponse<UserPo> saveUser(HttpServletRequest request, @RequestBody UserInVo userInVo){
        return userService.saveUser(userInVo);
    }

    @GetMapping(value = "/deleteUser/{id}")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public HttpResponse<String> deleteUser(HttpServletRequest request,@PathVariable("id")Integer id){
        return userService.deleteUser(id);
    }
}
