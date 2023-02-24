package priv.library.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import priv.library.entity.base.CommonResult;
import priv.library.entity.base.ErrorCode;
import priv.library.entity.output.QueryLibraryBookOutPut;
import priv.library.entity.po.LibraryBookPO;
import priv.library.entity.vo.AddLibraryBookVO;
import priv.library.entity.vo.QueryLibraryBookVO;
import priv.library.entity.vo.UpdateLibraryBookVO;
import priv.library.service.IBookService;
import priv.library.service.LibraryBookService;

import javax.annotation.Resource;

/**
 * @author Austin
 * @description
 * @date 2023/2/20 09:52
 */
@Service
public class IBookServiceImpl implements IBookService {
    /**
     * 新增图书
     *
     * @param bookVO
     * @return CommonResult
     */
    @Override
    public CommonResult<?> addBook(AddLibraryBookVO bookVO) {
        LibraryBookPO bookPO = new LibraryBookPO();
        BeanUtils.copyProperties(bookVO, bookPO);
        libraryBookService.save(bookPO);

        return CommonResult.success( bookPO.getBookId());
    }

    /**
     * 查询图书列表
     *
     * @param queryBookVO
     * @return CommonResult
     */
    @Override
    public CommonResult<?> queryBook(QueryLibraryBookVO queryBookVO) {
        Page<LibraryBookPO> page = new Page<>(queryBookVO.getPageNum(), queryBookVO.getPageSize());

        LambdaQueryWrapper<LibraryBookPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq( queryBookVO.getBookId() != null, LibraryBookPO::getBookId, queryBookVO.getBookId());
        wrapper.like( StrUtil.isNotEmpty( queryBookVO.getBookName()), LibraryBookPO::getBookName,
                queryBookVO.getBookName());
        wrapper.like( StrUtil.isNotEmpty( queryBookVO.getBookDescription()), LibraryBookPO::getBookDescription,
                queryBookVO.getBookDescription());

        return CommonResult.success( libraryBookService.page( page, wrapper));
    }

    /**
     * 更新图书
     *
     * @param bookVO
     * @return CommonResult
     */
    @Override
    public CommonResult<?> updateBook(UpdateLibraryBookVO bookVO) {
        LibraryBookPO bookPO = new LibraryBookPO();
        BeanUtils.copyProperties(bookVO, bookPO);
        if( libraryBookService.getById( bookPO.getBookId().intValue()) == null){
            return CommonResult.failed(ErrorCode.RECORD_NOT_EXIST_FAILED, "图书记录不存在");
        }

        boolean isUpdated = libraryBookService.updateById( bookPO);
        if( isUpdated){
            return CommonResult.success();
        }else{
            return CommonResult.failed(ErrorCode.DB_SQL_FAILED, "更新失败");
        }
    }

    /**
     * 删除图书
     *
     * @param bookId
     * @return CommonResult
     */
    @Override
    public CommonResult<?> deleteBook(int bookId) {
        libraryBookService.removeById( bookId);

        return CommonResult.success();
    }

    /**
     * 查询图书详情
     *
     * @param bookId
     * @return CommonResult
     */
    @Override
    public CommonResult<QueryLibraryBookOutPut> getBookDetail(int bookId) {
        LibraryBookPO bookPO = libraryBookService.getById( bookId);
        if( bookPO == null){
            return CommonResult.failed(ErrorCode.RECORD_NOT_EXIST_FAILED, "图书记录不存在 id:"+ bookId);
        }else{
            QueryLibraryBookOutPut outPut = new QueryLibraryBookOutPut();
            BeanUtils.copyProperties( bookPO, outPut);

            return CommonResult.success( outPut);
        }
    }

    @Resource
    LibraryBookService libraryBookService;
}
