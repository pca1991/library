package priv.library.entity.vo;

import lombok.Data;
import priv.library.annotation.ByteLength;

import javax.validation.constraints.NotNull;

/**
 * @author Austin
 * @description 查询图书vo
 * @date 2023/2/20 09:27
 */
@Data
public class QueryLibraryBookVO {
    /**
     * 图书id
     */
    private Integer bookId;
    /**
     * 图书名称
     */
    @ByteLength(max = 64, message = "图书名称长度超限")
    private String bookName;

    /**
     * 图书描述
     */
    @ByteLength(max = 128, message = "图书描述长度超限")
    private String bookDescription;

    /**
     * 当前页数
     */
    @NotNull(message = "当前页数不能为空")
    private Integer pageNum;

    /**
     * 每页记录数
     */
    @NotNull(message = "每页记录数不能为空")
    private Integer pageSize;
}
