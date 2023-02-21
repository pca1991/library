package priv.library.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.library.domain.base.CommonResult;
import priv.library.service.IUserService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Austin
 * @description 用户控制层
 * @date 2023/2/19 18:16
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"用户接口"})
public class UserController {

    @ApiOperation("用户登录")
    @GetMapping("login")
    public CommonResult<?> login(@NotNull(message = "用户名不能为空") @Size(max = 16, message = "用户名不能超过16") @ApiParam(value = "用户名", example = "user") String userName,
                                 @NotNull(message = "用户密码不能为空") @Size(max = 16, message = "用户密码不能超过16") @ApiParam(value = "用户密码", example = "111111") String userPassword) {

        return userService.login( userName, userPassword);
    }

    @ApiOperation("用户登出")
    @SaCheckLogin
    @GetMapping("logout")
    public CommonResult<?> logout() {

        return userService.logout();
    }

    @Resource
    IUserService userService;
}
