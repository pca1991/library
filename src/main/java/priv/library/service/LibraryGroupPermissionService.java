package priv.library.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import priv.library.domain.po.LibraryGroupPermissionPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface LibraryGroupPermissionService extends IService<LibraryGroupPermissionPO> {
    /**
     * 通过groupId查找权限列表
     * @param groupId
     * @return List<String>
     */
    List<LibraryGroupPermissionPO> selectPermissionByGroupId(int groupId);
}
