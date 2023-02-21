package priv.library.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import priv.library.annotation.ByteLength;

import javax.validation.constraints.NotNull;

/**
 * @author Austin
 * @description 更新图书vo
 * @date 2023/2/20 09:27
 */
@Data
@ApiModel("更新图书请求对象")
public class UpdateLibraryBookVO {
    /**
     * 图书id
     */
    @NotNull(message = "图书id不能为空")
    @ApiModelProperty(value = "图书id", example = "1")
    private Integer bookId;
    /**
     * 图书名称
     */
    @ApiModelProperty(value = "图书名称")
    @ByteLength(max = 64, message = "图书名称长度超限")
    private String bookName;

    /**
     * 图书描述
     */
    @ApiModelProperty(value = "图书描述")
    @ByteLength(max = 128, message = "图书描述长度超限")
    private String bookDescription;
}
