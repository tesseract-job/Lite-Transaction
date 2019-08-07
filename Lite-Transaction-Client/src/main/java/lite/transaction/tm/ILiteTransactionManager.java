package lite.transaction.tm;

import lite.transaction.exception.LiteTransactionException;

/**
 * TM接口，负责向TC提交事务，创建事务，回滚事务
 *
 * @author nickle
 */
public interface ILiteTransactionManager {
    /**
     * 向TM创建新的事务
     *
     * @return XID
     */
    String createTransaction() throws LiteTransactionException;

    /**
     * 向TM提交事务
     *
     * @author nickle
     */
    void commitTransaction() throws LiteTransactionException;

    /**
     * 向TM回滚事务
     *
     * @throws LiteTransactionException
     */
    void rollbackTransaction() throws LiteTransactionException;
}
