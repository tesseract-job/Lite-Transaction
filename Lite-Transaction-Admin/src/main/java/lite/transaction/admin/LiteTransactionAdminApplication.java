package lite.transaction.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author: LeoLee
 * @date: 2019/11/1 17:52
 */
@SpringBootApplication
public class LiteTransactionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteTransactionAdminApplication.class, args);
    }
}
