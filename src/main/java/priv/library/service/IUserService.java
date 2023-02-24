package priv.library.service;

import priv.library.entity.base.CommonResult;

/**
 * @author Austin
 * @description 用户接口
 * @date 2023/2/19 18:33
 */
public interface IUserService {
    /**
     * 用户登录接口
     * @param userName
     * @param userPassword
     * @return CommonResult
     */
    CommonResult<?> login(String userName, String userPassword);

    /**
     * 用户登出接口
     * @return CommonResult
     */
    CommonResult<?> logout();
}
