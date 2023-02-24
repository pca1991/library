package priv.library.mapper;
import org.apache.ibatis.annotations.Param;

import priv.library.entity.po.LibraryUserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity priv.library.domain.po.LibraryUser
 */
public interface LibraryUserMapper extends BaseMapper<LibraryUserPO> {
    /**
     * 通过用户名称查找用户
     * @param userName
     * @return LibraryUser
     */
    LibraryUserPO selectOneByUserName(@Param("userName") String userName);
}




