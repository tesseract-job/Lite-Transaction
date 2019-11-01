package lite.transaction.db.SQLHandler;

import com.alibaba.druid.sql.ast.SQLStatement;
import lite.transaction.context.LiteTransactionContext;
import lite.transaction.db.log.IUndoLog;

/**
 * @program: Lite-Transaction
 * @description: SQL 解析生成 undo log 处理器
 * @author: nickle
 * @create: 2019-11-01 15:39
 **/
public interface ISQLHandler {
    IUndoLog buildUndoLog(LiteTransactionContext context, SQLStatement sqlStatement);
}
