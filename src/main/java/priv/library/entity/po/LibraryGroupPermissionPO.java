package priv.library.entity.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 用户组权限表
 * @TableName library_group_permission
 */
@TableName(value ="library_group_permission")
@Data
public class LibraryGroupPermissionPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 用户组id
     */
    private Integer groupId;

    /**
     * 权限
     */
    private String permission;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}