package priv.library.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import priv.library.entity.base.CommonResult;
import priv.library.entity.vo.AddLibraryBookVO;
import priv.library.entity.vo.UpdateLibraryBookVO;
import priv.library.service.IBookService;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @author Austin
 * @description 图书控制层
 * @date 2023/2/19 20:13
 */
@Validated
@SaCheckLogin
@RestController
@RequestMapping("/book")
@Api(value = "图书接口", tags = {"2-图书接口"})
public class BookController {

    @SaCheckPermission("book:add")
    @PostMapping("/add")
    @ApiOperation("新增图书")
    public CommonResult<?> addBook(@RequestBody @Valid AddLibraryBookVO addLibraryBookVO){
        return bookService.addBook( addLibraryBookVO);
    }

    @SaCheckPermission("book:delete")
    @DeleteMapping("/delete/{bookId}")
    @ApiOperation("删除图书")
    public CommonResult<?> deleteBook(@PathVariable @NotNull(message = "图书id不能为空")
                                          @Range(min = 1, max = Integer.MAX_VALUE, message = "图书id不合法")
                                          @ApiParam(value = "图书id",example = "1") Integer bookId){
        return bookService.deleteBook( bookId);
    }

    @SaCheckPermission("book:update")
    @PutMapping("/update")
    @ApiOperation("更新图书")
    public CommonResult<?> updateBook(@RequestBody @Valid UpdateLibraryBookVO updateLibraryBookVO){
        return bookService.updateBook( updateLibraryBookVO);
    }

    @SaCheckPermission("book:query")
    @GetMapping("/{id}")
    @ApiOperation("查询图书")
    public CommonResult<?> getBook(@PathVariable @NotNull(message = "图书id不能为空")
                                       @Range(min = 1, max = Integer.MAX_VALUE, message = "图书id值不合法")
                                       @ApiParam(value = "图书id",example = "1") Integer id){
        return bookService.getBookDetail(id);
    }


    @Resource
    IBookService bookService;
}
