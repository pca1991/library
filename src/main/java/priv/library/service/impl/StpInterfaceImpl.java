package priv.library.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.stereotype.Component;
import priv.library.entity.po.LibraryGroupPermissionPO;
import priv.library.entity.po.LibraryUserPO;
import priv.library.service.LibraryGroupPermissionService;
import priv.library.service.LibraryUserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Austin
 * @description 自定义权限验证接口扩展
 * @date 2023/2/20 15:56
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        LibraryUserPO userPO = libraryUserService.getById( Integer.parseInt( loginId.toString()));
        if( BeanUtil.isNotEmpty( userPO)){
            List<LibraryGroupPermissionPO> list =
                    libraryGroupPermissionService.selectPermissionByGroupId( userPO.getGroupId());

            return list.stream().map( LibraryGroupPermissionPO::getPermission).collect(Collectors.toList());
        }

        return null;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }

    @Resource
    LibraryUserService libraryUserService;
    @Resource
    LibraryGroupPermissionService libraryGroupPermissionService;

}
