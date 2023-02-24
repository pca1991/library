package priv.library.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import priv.library.entity.base.CommonResult;
import priv.library.service.IUserService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Austin
 * @description 用户控制层
 * @date 2023/2/19 18:16
 */
@Validated
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"1-用户接口"})
public class UserController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonResult<?> login(@RequestParam @NotNull(message = "用户名不能为空") @Size(max = 16, message = "用户名不能超过16") @ApiParam(value = "用户名") String userName,
                                 @RequestParam @NotNull(message = "用户密码不能为空") @Size(max = 16, message = "用户密码不能超过16") @ApiParam(value = "用户密码") String userPassword) {

        return userService.login( userName, userPassword);
    }

    @ApiOperation("用户登出")
    @SaCheckLogin
    @PostMapping("/logout")
    public CommonResult<?> logout() {

        return userService.logout();
    }

    @Resource
    IUserService userService;
}
