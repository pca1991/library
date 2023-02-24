package priv.library.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Service;
import priv.library.entity.po.LibraryUserPO;
import priv.library.entity.base.CommonResult;
import priv.library.entity.base.ErrorCode;
import priv.library.service.IUserService;
import priv.library.service.LibraryUserService;

import javax.annotation.Resource;

/**
 * @author Austin
 * @description 用户接口实现类
 * @date 2023/2/19 18:34
 */
@Service
public class IUserServiceImpl implements IUserService {
    /**
     * 用户登录接口
     *
     * @param userName
     * @param userPassword
     * @return CommonResult
     */
    @Override
    public CommonResult<?> login(String userName, String userPassword) {
        LibraryUserPO user = libraryUserService.selectOneByUserName( userName);
        if( user != null && userPassword.equals(user.getUserPassword())){
            StpUtil.login( user.getUserId());
            return CommonResult.success();
        }else{
            return CommonResult.failed(ErrorCode.NOT_USER_FAILED);
        }

    }

    /**
     * 用户登出接口
     *
     * @return CommonResult
     */
    @Override
    public CommonResult<?> logout() {
        StpUtil.logout();

        return CommonResult.success();
    }

    @Resource
    LibraryUserService libraryUserService;
}
