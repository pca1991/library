package priv.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import priv.library.domain.po.LibraryUserPO;

/**
 *
 */
public interface LibraryUserService extends IService<LibraryUserPO> {
    /**
     * 通过用户名称查找用户
     * @param userName
     * @return LibraryUser
     */
    LibraryUserPO selectOneByUserName(@Param("userName") String userName);

    /**
     * 通过用户id查用户
     * @param id
     * @return LibraryUserPO
     */
    LibraryUserPO getById(int id);
}
