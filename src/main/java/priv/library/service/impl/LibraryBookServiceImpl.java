package priv.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import priv.library.domain.po.LibraryBookPO;
import priv.library.service.LibraryBookService;
import priv.library.mapper.LibraryBookMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author qxu
 */
@Service
@CacheConfig(cacheNames = "library-book")
public class LibraryBookServiceImpl extends ServiceImpl<LibraryBookMapper, LibraryBookPO>
implements LibraryBookService{

    @Override
    @Cacheable(key = "#id", condition = "#id > 0", unless = "#result == null")
    public LibraryBookPO getById(int id) {
        return super.getById(id);
    }

    @Override
    @CacheEvict(key = "#entity.bookId", condition = "#entity.bookId != null")
    public boolean updateById(LibraryBookPO entity) {
        return super.updateById(entity);
    }

    @Override
    @CacheEvict(key = "#id", condition = "#id > 0")
    public boolean removeById(int id){
        return super.removeById( id);
    }
}




