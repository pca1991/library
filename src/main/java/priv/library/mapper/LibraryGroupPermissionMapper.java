package priv.library.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import priv.library.domain.po.LibraryGroupPermissionPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity priv.library.domain.po.LibraryGroupPermission
 */
public interface LibraryGroupPermissionMapper extends BaseMapper<LibraryGroupPermissionPO> {
    /**
     * 通过groupId查找权限列表
     * @param groupId
     * @return List<LibraryGroupPermissionPO>
     */
    List<LibraryGroupPermissionPO> selectPermissionByGroupId(@Param("groupId") Integer groupId);
}




