package priv.library.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import priv.library.annotation.ByteLength;

import javax.validation.constraints.NotNull;

/**
 * @author Austin
 * @description 新增图书vo
 * @date 2023/2/20 09:27
 */
@Data
@ApiModel("创建图书请求对象")
public class AddLibraryBookVO {
    /**
     * 图书名称
     */
    @NotNull(message = "图书名称不能为空")
    @ByteLength(max = 64, message = "图书名称长度超限")
    @ApiModelProperty("图书名称")
    private String bookName;

    /**
     * 图书描述
     */
    @ByteLength(max = 128, message = "图书描述长度超限")
    @ApiModelProperty("图书描述")
    private String bookDescription;
}
