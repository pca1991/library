package priv.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import priv.library.entity.po.LibraryGroupPermissionPO;
import priv.library.mapper.LibraryGroupPermissionMapper;
import priv.library.service.LibraryGroupPermissionService;

import java.util.List;

/**
 *
 */
@Service
@CacheConfig(cacheNames = "library-group-permission")
public class LibraryGroupPermissionServiceImpl extends ServiceImpl<LibraryGroupPermissionMapper, LibraryGroupPermissionPO>
implements LibraryGroupPermissionService{

    /**
     * 通过groupId查找权限列表
     *
     * @param groupId
     * @return List<String>
     */
    @Override
    @Cacheable(key = "#groupId", condition = "#groupId > 0", unless = "#result == null")
    public List<LibraryGroupPermissionPO> selectPermissionByGroupId(int groupId) {
        return this.baseMapper.selectPermissionByGroupId( groupId);
    }
}




