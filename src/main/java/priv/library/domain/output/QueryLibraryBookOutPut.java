package priv.library.domain.output;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Austin
 * @description 查询图书结果对象
 * @date 2023/2/20 14:41
 */
@Data
public class QueryLibraryBookOutPut implements Serializable {
    private static final long serialVersionUID = 5266915457610710106L;
    /**
     * 图书id
     */
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
    private Integer createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
