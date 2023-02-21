package priv.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import priv.library.domain.po.LibraryUserPO;
import priv.library.service.LibraryUserService;
import priv.library.mapper.LibraryUserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@CacheConfig(cacheNames = "library-user")
public class LibraryUserServiceImpl extends ServiceImpl<LibraryUserMapper, LibraryUserPO>
implements LibraryUserService{

    /**
     * 通过用户名称查找用户
     *
     * @param userName
     * @return LibraryUser
     */
    @Override
    public LibraryUserPO selectOneByUserName(String userName) {
        return this.baseMapper.selectOneByUserName( userName);
    }

    /**
     * 通过用户id查用户
     *
     * @param id
     * @return LibraryUserPO
     */
    @Override
    @Cacheable(key = "#id", condition = "#id > 0", unless = "#result == null")
    public LibraryUserPO getById(int id) {
        return super.getById( id);
    }
}




