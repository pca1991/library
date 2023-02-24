package priv.library.entity.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 图书馆图书表
 * @TableName library_book
 */
@TableName(value ="library_book")
@Data
public class LibraryBookPO implements Serializable {
    /**
     * 图书id
     */
    @TableId(type = IdType.AUTO)
    private Integer bookId;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 图书描述
     */
    private String bookDescription;

    /**
     * 创建人id
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}