package lite.transaction.tm;

import lite.transaction.exception.LiteTransactionException;

/**
 * TM接口，负责向TC提交事务，创建事务，回滚事务
 *
 * @author nickle
 */
public interface ILiteTransactionManager {
    /**
     * 通知TM创建新的主事务
     *
     * @return XID 主事务ID
     * @throws LiteTransactionException
     */
    String createMasterTransaction() throws LiteTransactionException;

    /**
     * 通知TM创建新的分支事务
     *
     * @param XID 主分支ID
     * @return BXID slave事务ID
     * @throws LiteTransactionException
     */
    String createSlaveTransaction(String XID) throws LiteTransactionException;

    /**
     * 通知TC分支事务完成
     *
     * @param BXID slave分支ID
     * @throws LiteTransactionException
     */
    void commitSlaverTransaction(String BXID) throws LiteTransactionException;

    /**
     * 通知TC分支事务取消
     *
     * @param BXID slave分支ID
     * @throws LiteTransactionException
     */
    void cancelSlaverTransaction(String BXID) throws LiteTransactionException;

    /**
     * 通知TC提交所有事务
     *
     * @param XID 主分支ID
     * @throws LiteTransactionException
     */
    void commitMasterTransaction(String XID) throws LiteTransactionException;

    /**
     * 通知TM回滚事务
     *
     * @param XID 主分支ID
     * @throws LiteTransactionException
     */
    void rollbackTransaction(String XID) throws LiteTransactionException;
}
