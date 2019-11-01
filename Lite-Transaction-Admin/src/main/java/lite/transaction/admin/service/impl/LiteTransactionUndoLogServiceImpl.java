package lite.transaction.admin.service.impl;

import lite.transaction.admin.domain.entity.LiteTransactionUndoLog;
import lite.transaction.admin.dao.LiteTransactionUndoLogMapper;
import lite.transaction.admin.service.ILiteTransactionUndoLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  事务日志服务实现类
 * </p>
 *
 * @author LeoLee
 * @since 2019-11-01
 */
@Service
public class LiteTransactionUndoLogServiceImpl extends ServiceImpl<LiteTransactionUndoLogMapper, LiteTransactionUndoLog> implements ILiteTransactionUndoLogService {

}
