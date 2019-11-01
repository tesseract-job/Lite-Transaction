package lite.transaction;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import org.junit.Test;

import java.util.List;

/**
 * @program: Lite-Transaction
 * @description:
 * @author: nickle
 * @create: 2019-11-01 14:51
 **/
public class DBTest {
    @Test
    public void testDruid() {
        String selectSql = "select * from test";
        String insertSqlWithColumns = "insert into test(id,name,age) values(1,\"name\",17)";
        String updateSqlNoColumns = "insert into test values(1,\"name\",17)";
        String updateSql = "update test set name=\"udpateName\" where id=1 and age=2 and name=\"name\"";
        String deleteSql = "delete from test where name=\"name\" and age=18";
        MySqlStatementParser parser = new MySqlStatementParser(updateSql);
        SQLStatement statement = parser.parseStatement();
        MySqlUpdateStatement updateStatement = (MySqlUpdateStatement) statement;
        SQLExpr where = updateStatement.getWhere();
        List<SQLObject> children = where.getChildren();
        children.forEach(sqlObject -> {
            System.out.println(sqlObject);
        });
    }
}
