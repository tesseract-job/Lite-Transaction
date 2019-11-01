package lite.transaction.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lite.transaction.admin.domain.vo.LiteTransactionUndoLogVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务日志控制器
 * @author: LeoLee
 * @date: 2019/11/1 18:33
 */
@Api(tags = "事务日志控制器")
@RestController
@RequestMapping(value = "liteTransactionUndoLog")
public class LiteTransactionUndoLogController {


    @ApiOperation(value = "测试控制器")
    @GetMapping(value = "test")
    public LiteTransactionUndoLogVO test(){
        return new LiteTransactionUndoLogVO();
    }

}
