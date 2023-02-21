package priv.library.service;

import org.apache.ibatis.annotations.Param;
import priv.library.domain.po.LibraryUserPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

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
