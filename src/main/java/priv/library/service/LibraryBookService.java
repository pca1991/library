package priv.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.library.entity.po.LibraryBookPO;

/**
 *
 */
public interface LibraryBookService extends IService<LibraryBookPO> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    LibraryBookPO getById(int id);

    /**
     * 根据id更新记录
     * @param entity
     * @return boolean
     */
    @Override
    boolean updateById(LibraryBookPO entity);

    /**
     * 根据id删除记录
     * @param id
     * @return boolean
     */
    boolean removeById(int id);
}
