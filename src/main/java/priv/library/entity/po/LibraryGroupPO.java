package priv.library.entity.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 图书馆用户组表
 * @TableName library_group
 */
@TableName(value ="library_group")
@Data
public class LibraryGroupPO implements Serializable {
    /**
     * 用户组id
     */
    @TableId(type = IdType.AUTO)
    private Integer groupId;

    /**
     * 用户组名
     */
    private String groupName;

    /**
     * '状态，1：有效，0：无效'
     */
    private String state;

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