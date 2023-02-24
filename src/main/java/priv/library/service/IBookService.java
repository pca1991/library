package priv.library.service;

import priv.library.domain.base.CommonResult;
import priv.library.domain.vo.AddLibraryBookVO;
import priv.library.domain.vo.QueryLibraryBookVO;
import priv.library.domain.vo.UpdateLibraryBookVO;

/**
 * @author Austin
 * @description 图书接口
 * @date 2023/2/19 20:17
 */
public interface IBookService {
    /**
     * 新增图书
     * @param bookVO
     * @return CommonResult
     */
    CommonResult<?> addBook(AddLibraryBookVO bookVO);

    /**
     * 查询图书列表
     * @param queryBookVO
     * @return CommonResult
     */
    CommonResult<?> queryBook(QueryLibraryBookVO queryBookVO);

    /**
     * 更新图书
     * @param bookVO
     * @return CommonResult
     */
    CommonResult<?> updateBook(UpdateLibraryBookVO bookVO);

    /**
     * 删除图书
     * @param bookId
     * @return CommonResult
     */
    CommonResult<?> deleteBook(int bookId);

    /**
     * 查询图书详情
     * @param bookId
     * @return CommonResult
     */
    CommonResult<?> getBookDetail(int bookId);
}
