package priv.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import priv.library.entity.po.LibraryBookPO;
import priv.library.mapper.LibraryBookMapper;
import priv.library.service.LibraryBookService;

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




