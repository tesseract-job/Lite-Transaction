package lite.transaction.db.SQLHandler;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import lite.transaction.context.LiteTransactionContext;
import lite.transaction.db.log.IUndoLog;

/**
 * @program: Lite-Transaction
 * @description: 更新
 * @author: nickle
 * @create: 2019-11-01 15:44
 **/
public class UpdateSQLHandler implements ISQLHandler {
    @Override
    public IUndoLog buildUndoLog(LiteTransactionContext context, SQLStatement sqlStatement) {
        MySqlUpdateStatement mySqlUpdateStatement = (MySqlUpdateStatement) sqlStatement;

        return null;
    }
}
