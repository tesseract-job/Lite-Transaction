package lite.transaction.db;

import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @program: Lite-Transaction
 * @description: 代理jdbc connection
 * @author: nickle
 * @create: 2019-11-01 14:42
 **/
@AllArgsConstructor
public class LiteTransactionConnection implements Connection {
    private Connection proxyConnection;

    @Override
    public Statement createStatement() throws SQLException {
        Statement statement = proxyConnection.createStatement();
        return new LiteTransactionStatement(statement);
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return proxyConnection.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return proxyConnection.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return proxyConnection.nativeSQL(sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        proxyConnection.setAutoCommit(autoCommit);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return proxyConnection.getAutoCommit();
    }

    @Override
    public void commit() throws SQLException {
        proxyConnection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        proxyConnection.rollback();
    }

    @Override
    public void close() throws SQLException {
        proxyConnection.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return proxyConnection.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return proxyConnection.getMetaData();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        proxyConnection.setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return proxyConnection.isReadOnly();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        proxyConnection.setCatalog(catalog);
    }

    @Override
    public String getCatalog() throws SQLException {
        return proxyConnection.getCatalog();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        proxyConnection.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return proxyConnection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return proxyConnection.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        proxyConnection.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxyConnection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxyConnection.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxyConnection.prepareCall(sql,resultSetType,resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return proxyConnection.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        proxyConnection.setTypeMap(map);
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        proxyConnection.setHoldability(holdability);
    }

    @Override
    public int getHoldability() throws SQLException {
        return proxyConnection.getHoldability();
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return proxyConnection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return proxyConnection.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        proxyConnection.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        proxyConnection.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxyConnection.createStatement(resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxyConnection.prepareStatement(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxyConnection.prepareCall(sql,resultSetType,resultSetConcurrency,resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return proxyConnection.prepareStatement(sql,autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return proxyConnection.prepareStatement(sql,columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return proxyConnection.prepareStatement(sql,columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return proxyConnection.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return proxyConnection.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return proxyConnection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return proxyConnection.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return proxyConnection.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        proxyConnection.setClientInfo(name,value);
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        proxyConnection.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return proxyConnection.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return proxyConnection.getClientInfo();
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return proxyConnection.createArrayOf(typeName,elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return proxyConnection.createStruct(typeName,attributes);
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        proxyConnection.setSchema(schema);
    }

    @Override
    public String getSchema() throws SQLException {
        return proxyConnection.getSchema();
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        proxyConnection.abort(executor);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        proxyConnection.setNetworkTimeout(executor,milliseconds);
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return proxyConnection.getNetworkTimeout();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return proxyConnection.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return proxyConnection.isWrapperFor(iface);
    }
}
